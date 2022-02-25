package com.unicon.ipms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class More_Info extends AppCompatActivity {
    private EditText ET_fname,ET_lname,ET_email,ET_studentNo,ET_parentNo,ET_dept,ET_registration,ET_semester;
    private Button B_next;
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

        ET_fname.setText(sharedPrefManager.getInstance(this).getfname());
        ET_lname.setText(sharedPrefManager.getInstance(this).getlname());
        ET_email.setText(sharedPrefManager.getInstance(this).getEmail());
        B_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getData();
                Intent intent = new Intent(More_Info.this,More_info_2.class);
                startActivity(intent);
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
}