package com.unicon.ipms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class More_info_3 extends AppCompatActivity {
    private Button B_next,B_previous;
    private EditText ET_admission,ET_sgpa1,ET_sgpa2,ET_sgpa3,ET_sgpa4,ET_sgpa5,ET_sgpa6,ET_sgpa7,ET_sgpa8,ET_avgSgpa,ET_passout,ET_live,ET_dead;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info3);

        ET_admission = (EditText) findViewById(R.id.admission_year);
        ET_sgpa1 = (EditText) findViewById(R.id.first_sem_SGPA);
        ET_sgpa2 = (EditText) findViewById(R.id.second_sem_SGPA);
        ET_sgpa3 = (EditText) findViewById(R.id.third_sem_SGPA);
        ET_sgpa4 = (EditText) findViewById(R.id.fourth_sem_SGPA);
        ET_sgpa5 = (EditText) findViewById(R.id.fifth_sem_SGPA);
        ET_sgpa6 = (EditText) findViewById(R.id.sixth_sem_SGPA);
        ET_sgpa7 = (EditText) findViewById(R.id.seventh_sem_SGPA);
        ET_sgpa8 = (EditText) findViewById(R.id.eight_sem_SGPA);
        ET_avgSgpa = (EditText) findViewById(R.id.avergae_SGPA);
        ET_passout = (EditText)  findViewById(R.id.Graduation_year);
        ET_live = (EditText)  findViewById(R.id.live_backlog);
        ET_dead = (EditText) findViewById(R.id.dead_backlog);
        B_next=findViewById(R.id.button_next);
        B_previous=findViewById(R.id.button_previous);

        try {
            ET_admission.setText(sharepref_moreInfo.getInstance(this).getadmission());
            ET_sgpa1.setText(sharepref_moreInfo.getInstance(this).getsgpa1());
            ET_sgpa2.setText(sharepref_moreInfo.getInstance(this).getsgpa2());
            ET_sgpa3.setText(sharepref_moreInfo.getInstance(this).getsgpa3());
            ET_sgpa4.setText(sharepref_moreInfo.getInstance(this).getsgpa4());
            ET_sgpa5.setText(sharepref_moreInfo.getInstance(this).getsgpa5());
            ET_sgpa6.setText(sharepref_moreInfo.getInstance(this).getsgpa6());
            ET_sgpa7.setText(sharepref_moreInfo.getInstance(this).getsgpa7());
            ET_sgpa8.setText(sharepref_moreInfo.getInstance(this).getsgpa8());
            ET_avgSgpa.setText(sharepref_moreInfo.getInstance(this).getavgSgpa());
            ET_passout.setText(sharepref_moreInfo.getInstance(this).getpassout());
            ET_live.setText(sharepref_moreInfo.getInstance(this).getlive());
            ET_dead.setText(sharepref_moreInfo.getInstance(this).getdead());
        }catch (Exception e){
            //do nothing
        }


        B_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validation());
                else {
                    getData();
                    Intent intent = new Intent(More_info_3.this, More_info_4.class);
                    startActivity(intent);
                }
            }
        });
        B_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();
                onNavigateUp();
                finish();
            }
        });


    }
    public void getData(){
        String admission, sgpa1,sgpa2,sgpa3,sgpa4,sgpa5,sgpa6,sgpa7,sgpa8,avgSgpa,passout,live,dead;
        admission = ET_admission.getText().toString().trim();
        sgpa1 = ET_sgpa1.getText().toString().trim();
        sgpa2 = ET_sgpa2.getText().toString().trim();
        sgpa3 = ET_sgpa3.getText().toString().trim();
        sgpa4 = ET_sgpa4.getText().toString().trim();
        sgpa5 = ET_sgpa5.getText().toString().trim();
        sgpa6 = ET_sgpa6.getText().toString().trim();
        sgpa7 = ET_sgpa7.getText().toString().trim();
        sgpa8 = ET_sgpa8.getText().toString().trim();
        avgSgpa = ET_avgSgpa.getText().toString().trim();
        passout = ET_passout.getText().toString().trim();
        live = ET_live.getText().toString().trim();
        dead = ET_dead.getText().toString().trim();


        sharepref_moreInfo.getInstance(getApplicationContext())
                .moreInfo3(admission,sgpa1,sgpa2,sgpa3,sgpa4,sgpa5,sgpa6,sgpa7,sgpa8,avgSgpa,passout,live,dead);
    }
    private boolean validation(){
        Functions f=new Functions();
        /*Enginnering Admission Year*/
        if(!f.invalidYear(ET_admission.getText().toString()))
        {
            if(f.cannotBeBlank(ET_admission.getText().toString()))
            {
                Toast.makeText(More_info_3.this, "Engineering Admission Year cannot be blank", Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(More_info_3.this, "Engineering Admission Year is invalid", Toast.LENGTH_LONG).show();
            }
            return true;
        }
        /*CGPA*/
        if (f.invalidCGPA(ET_sgpa1.getText().toString()))
        {
                Toast.makeText(More_info_3.this, "Invalid 1st Sem SGPA", Toast.LENGTH_LONG).show();
                return true;

        }
        if (f.invalidCGPA(ET_sgpa2.getText().toString()))
        {
            Toast.makeText(More_info_3.this, "Invalid 2nd Sem SGPA", Toast.LENGTH_LONG).show();
            return true;
        }
        if (f.invalidCGPA(ET_sgpa3.getText().toString()))
        {
            Toast.makeText(More_info_3.this, "Invalid 3rd Sem SGPA", Toast.LENGTH_LONG).show();
            return true;
        }
        if (f.invalidCGPA(ET_sgpa4.getText().toString()))
        {
            Toast.makeText(More_info_3.this, "Invalid 4th Sem SGPA", Toast.LENGTH_LONG).show();
            return true;
        }
        if (f.invalidCGPA(ET_sgpa5.getText().toString()))
        {
            Toast.makeText(More_info_3.this, "Invalid 5th Sem SGPA", Toast.LENGTH_LONG).show();
            return true;
        }
        if (f.invalidCGPA(ET_sgpa6.getText().toString()))
        {
            Toast.makeText(More_info_3.this, "Invalid 6th Sem SGPA", Toast.LENGTH_LONG).show();
            return true;
        }
        if (f.invalidCGPA(ET_sgpa7.getText().toString()))
        {
            Toast.makeText(More_info_3.this, "Invalid 7th Sem SGPA", Toast.LENGTH_LONG).show();
            return true;
        }
        if (f.invalidCGPA(ET_sgpa8.getText().toString()))
        {
            Toast.makeText(More_info_3.this, "Invalid 8th Sem SGPA", Toast.LENGTH_LONG).show();
            return true;
        }
        if (f.invalidCGPA(ET_avgSgpa.getText().toString()))
        {
            Toast.makeText(More_info_3.this, "Invalid Average SGPA", Toast.LENGTH_LONG).show();
            return true;
        }
        if(!f.invalidYear(ET_passout.getText().toString()))
        {
            if(f.cannotBeBlank(ET_passout.getText().toString()))
            {
                Toast.makeText(More_info_3.this, "Graduation Year cannot be blank", Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(More_info_3.this, "Graduation Admission Year is invalid", Toast.LENGTH_LONG).show();
            }
            return true;
        }
        return false;
    }

}