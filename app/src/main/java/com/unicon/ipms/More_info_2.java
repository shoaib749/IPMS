package com.unicon.ipms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class More_info_2 extends AppCompatActivity {
    private Button B_next,B_previous;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info2);
        B_next=findViewById(R.id.button_next);
        B_previous=findViewById(R.id.button_previous);
        B_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(More_info_2.this,More_info_3.class);
                startActivity(intent);
            }
        });
        B_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(More_info_2.this,More_Info.class);
                startActivity(intent);
            }
        });


    }
//    public void getInfo(){
//        String pass10,per10,pass12,per12,passDip,perDip;
//        sharepref_moreInfo.getInstance(this)
//                .moreInfo2(pass10,per10,pass12,per12,passDip,perDip);
//    }
}