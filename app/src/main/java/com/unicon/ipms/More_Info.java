package com.unicon.ipms;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class More_Info extends AppCompatActivity {
    private EditText ET_fname,ET_lname,ET_email,ET_studentNo,ET_parentNo,ET_dept,ET_registration,ET_semester;
    private Button B_next;
    private Functions f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);
        ET_fname = (EditText) findViewById(R.id.First_Name);
        ET_lname = (EditText) findViewById(R.id.Last_Name);
        ET_email = (EditText) findViewById(R.id.Email);
        ET_studentNo = (EditText) findViewById(R.id.Student_no);
        ET_parentNo = (EditText) findViewById(R.id.Parent_no);
        ET_dept = (EditText) findViewById(R.id.Department_name);
        ET_registration = (EditText) findViewById(R.id.Registration_no);
        ET_semester = (EditText) findViewById(R.id.Semester_ET);
        B_next = (Button) findViewById(R.id.button_next);
        f=new Functions();
        B_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validations());
                else {
                    getData();
                    Intent intent = new Intent(More_Info.this, More_info_2.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void getData() {
        String fname,lname,email,studentNo,parentNo,dept,registration,sem;
        fname = ET_fname.getText().toString().trim();
        lname = ET_lname.getText().toString().trim();
        email = ET_email.getText().toString().trim();
        studentNo = ET_studentNo.getText().toString().trim();
        parentNo = ET_parentNo.getText().toString().trim();
        dept = ET_dept.getText().toString().trim();
        registration = ET_registration.getText().toString().trim();
        sem = ET_semester.getText().toString().trim();

        //method to store data in sharedprefmanager
        sharepref_moreInfo.getInstance(getApplicationContext())
                .moreInfo_1(fname,lname,email,studentNo,parentNo,dept,registration,sem);

    }
    private boolean validations(){
        /*FIRST NAME*/
        if (!f.isStringOnlyAlphabet(ET_fname.getText().toString())) {
            if (TextUtils.isEmpty(ET_fname.getText().toString()))
            {
                Toast.makeText(More_Info.this, "First Name cannot be empty", Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(More_Info.this, "First Name can only contain alphabets", Toast.LENGTH_LONG).show();
            }

            return true;
        }
        else if (f.invalidNoOfChars(ET_fname.getText().toString(),16))
        {
            Toast.makeText(More_Info.this, "First Name cannot contain more than 16 alphabets", Toast.LENGTH_LONG).show();
            return  true;
        }
        /*LAST NAME*/
        if (!f.isStringOnlyAlphabet(ET_lname.getText().toString())) {
            if (TextUtils.isEmpty(ET_lname.getText().toString()))
            {
                Toast.makeText(More_Info.this, "Last Name cannot be empty", Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(More_Info.this, "Last Name can only contain alphabets", Toast.LENGTH_LONG).show();
            }
            return true;
        }
        else if (f.invalidNoOfChars(ET_lname.getText().toString(),16))
        {
            Toast.makeText(More_Info.this, "Last Name cannot contain more than 16 alphabets", Toast.LENGTH_LONG).show();
            return  true;
        }
        /*Email Phone No*/
        if(!f.invalidEmail(ET_email.getText().toString()))
        {
            if (TextUtils.isEmpty(ET_email.getText().toString()))
            {
                Toast.makeText(More_Info.this, "Email cannot be empty", Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(More_Info.this, "Invalid Email", Toast.LENGTH_LONG).show();
                return true;
            }
        }
        /*Student PHONE NO*/
        if(!f.invalidPhone(ET_studentNo.getText().toString())){
            if(f.cannotBeBlank(ET_studentNo.getText().toString()))
            {
                Toast.makeText(More_Info.this, "Student Mobile Number cannot be blank", Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(More_Info.this, "Invalid Student Phone Number", Toast.LENGTH_LONG).show();
            }
            return true;
        }
        /*Parent PHONE NO*/
        if(!f.invalidPhone(ET_parentNo.getText().toString())){
            if(f.cannotBeBlank(ET_parentNo.getText().toString()))
            {
                Toast.makeText(More_Info.this, "Parent Mobile Number cannot be blank", Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(More_Info.this, "Invalid Parent Phone Number", Toast.LENGTH_LONG).show();
            }
            return true;
        }
        /*Registration NO*/
        if(!f.invalidNum(ET_registration.getText().toString())){
            if(f.cannotBeBlank(ET_registration.getText().toString()))
            {
                Toast.makeText(More_Info.this, "Registration Number cannot be blank", Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(More_Info.this, "Invalid Registration Number", Toast.LENGTH_LONG).show();
            }
            return true;
        }




        return false;
    }

}