package com.unicon.ipms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button Student;
    private Button Admin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Student=findViewById(R.id.Student);
        Admin=findViewById(R.id.Admin);
        Student.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
             openActivity2();
            }

        });
    }
    public void openActivity2(){
        Intent intent =new Intent(this,Create_Info.class);
        startActivity(intent);
    }
}