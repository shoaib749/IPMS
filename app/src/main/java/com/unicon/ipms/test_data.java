package com.unicon.ipms;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class test_data extends AppCompatActivity {
    private TextView fname,lname,email,admission,studentNo,parentNo,dept,sem,pass10,pass12,per10,per12,passDip,perDip,sgpa1,sgpa2,sgpa3,sgpa4,sgpa5,sgpa6,sgpa7,sgpa8,regNo;
    private TextView option1,status,gap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_data);
        fname = (TextView) findViewById(R.id.fname);
        lname = (TextView) findViewById(R.id.lname);
        email = (TextView) findViewById(R.id.email);
        admission = (TextView) findViewById(R.id.admission);
        studentNo = (TextView) findViewById(R.id.student_no);
        parentNo = (TextView) findViewById(R.id.parentNo);
        dept = (TextView) findViewById(R.id.dept);
        sem = (TextView) findViewById(R.id.sem);
        pass10 = (TextView) findViewById(R.id.pass10);
        per10 = (TextView) findViewById(R.id.per10);
        pass12 = (TextView) findViewById(R.id.pass12);
        perDip = (TextView) findViewById(R.id.perDip);
        passDip = (TextView) findViewById(R.id.passDip);
        per12 = (TextView) findViewById(R.id.per12);
        sgpa1 = (TextView) findViewById(R.id.sgpa1);
        sgpa2 = (TextView) findViewById(R.id.sgpa2);
        sgpa3 = (TextView) findViewById(R.id.sgpa3);
        sgpa4 = (TextView) findViewById(R.id.sgpa4);
        sgpa5 = (TextView) findViewById(R.id.sgpa5);
        sgpa6 = (TextView) findViewById(R.id.sgpa6);
        sgpa7 = (TextView) findViewById(R.id.sgpa7);
        sgpa8 = (TextView) findViewById(R.id.sgpa8);
        regNo = (TextView) findViewById(R.id.regNo);
        option1 = (TextView) findViewById(R.id.option1);
        status = (TextView) findViewById(R.id.status);
        gap = (TextView) findViewById(R.id.gap);

        fname.setText(sharepref_moreInfo.getInstance(this).getfname());
        lname.setText(sharepref_moreInfo.getInstance(this).getlname());
        email.setText(sharepref_moreInfo.getInstance(this).getemail());
        admission.setText(sharepref_moreInfo.getInstance(this).getadmission());
        studentNo.setText(sharepref_moreInfo.getInstance(this).getstudentNo());
        parentNo.setText(sharepref_moreInfo.getInstance(this).getparentsNo());
        sem.setText(sharepref_moreInfo.getInstance(this).getsemester());
        dept.setText(sharepref_moreInfo.getInstance(this).getdept());
        pass10.setText(sharepref_moreInfo.getInstance(this).getpass10());
        pass12.setText(sharepref_moreInfo.getInstance(this).getpass12());
        per10.setText(sharepref_moreInfo.getInstance(this).getper10());
        per12.setText(sharepref_moreInfo.getInstance(this).getper12());
        passDip.setText(sharepref_moreInfo.getInstance(this).getpassDip());
        perDip.setText(sharepref_moreInfo.getInstance(this).getperDip());
        sgpa1.setText(sharepref_moreInfo.getInstance(this).getsgpa1());
        sgpa2.setText(sharepref_moreInfo.getInstance(this).getsgpa2());
        sgpa3.setText(sharepref_moreInfo.getInstance(this).getsgpa3());
        sgpa4.setText(sharepref_moreInfo.getInstance(this).getsgpa4());
        sgpa5.setText(sharepref_moreInfo.getInstance(this).getsgpa5());
        sgpa6.setText(sharepref_moreInfo.getInstance(this).getsgpa6());
        sgpa7.setText(sharepref_moreInfo.getInstance(this).getsgpa7());
        sgpa8.setText(sharepref_moreInfo.getInstance(this).getsgpa8());
        regNo.setText(sharepref_moreInfo.getInstance(this).getregistration());
        option1.setText(sharepref_moreInfo.getInstance(this).getoption1());
        status.setText(sharepref_moreInfo.getInstance(this).getplacement_status());
        gap.setText(sharepref_moreInfo.getInstance(this).getgap());






    }
}