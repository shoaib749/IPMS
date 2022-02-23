package com.unicon.ipms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class More_info_3 extends AppCompatActivity {
    private Button B_next,B_previous;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info3);
        B_next=findViewById(R.id.button_next);
        B_previous=findViewById(R.id.button_previous);
        B_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(More_info_3.this,More_info_4.class);
                startActivity(intent);
            }
        });
        B_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(More_info_3.this,More_info_2.class);
                startActivity(intent);
            }
        });


    }
//    public void getData(){
//        String admission, sgpa1,sgpa2,sgpa3,sgpa4,sgpa5,sgpa6,sgpa7,sgpa8,avgSgpa,passout,live,dead;
//        sharepref_moreInfo.getInstance(getApplicationContext())
//                .moreInfo3(admission,sgpa1,sgpa2,sgpa3,sgpa4,sgpa5,sgpa6,sgpa7,sgpa8,avgSgpa,passout,live,dead);
//    }
}