package com.unicon.ipms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class More_info_2 extends AppCompatActivity {
    private EditText ET_pass10,ET_per10,ET_pass12,ET_per12,ET_passDip,ET_perDip;
    private Button B_next,B_previous;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info2);
        ET_pass10 = (EditText) findViewById(R.id.ssc_year);
        ET_per10 = (EditText) findViewById(R.id.ssc_percent);
        ET_pass12 = (EditText) findViewById(R.id.hsc_year);
        ET_per12 = (EditText) findViewById(R.id.hse_percent);
        ET_passDip = (EditText) findViewById(R.id.diploma_year);
        ET_perDip = (EditText) findViewById(R.id.diploma_percent);
        B_next = (Button) findViewById(R.id.button_next);
        B_previous = (Button) findViewById(R.id.button_previous);
        B_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getInfo();
                Intent intent = new Intent(More_info_2.this,More_info_3.class);
                startActivity(intent);
            }
        });
        B_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(More_info_2.this,More_Info.class);
                startActivity(intent);
            }
        });
    }
    public void getInfo(){
        String pass10,per10,pass12,per12,passDip,perDip;
        pass10 = ET_pass10.getText().toString().trim();
        per10 = ET_per10.getText().toString().trim();
        pass12 = ET_pass12.getText().toString().trim();
        per12 = ET_per12.getText().toString().trim();
        passDip = ET_passDip.getText().toString().trim();
        perDip = ET_perDip.getText().toString().trim();

        sharepref_moreInfo.getInstance(this)
                .moreInfo2(pass10,per10,pass12,per12,passDip,perDip);
    }
}