package com.unicon.ipms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Sign_in extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        Button submit = findViewById(R.id.next);
        submit.setOnClickListener(view -> openActivity4());
    }
    public void openActivity4(){
        Intent intent =new Intent(this,More_Info.class);
        startActivity(intent);
    }
}