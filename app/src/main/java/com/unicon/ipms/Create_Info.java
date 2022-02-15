package com.unicon.ipms;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Create_Info extends AppCompatActivity {
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_info);
        submit = findViewById(R.id.submit);
        submit.setOnClickListener(view -> openActivity3());
    }
    public void openActivity3(){
        Intent intent =new Intent(this,Sign_in.class);
        startActivity(intent);
    }
    }