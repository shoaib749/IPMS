package com.unicon.ipms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button Student;
    private Button Admin;
    public static Context contextOfApplication;
    public static Context getContextOfApplication()
    {
        return contextOfApplication;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contextOfApplication = getApplicationContext();
        if(sharedPrefManager.getInstance(this).islogedIn()){
            finish();
            startActivity(new Intent(MainActivity.this,student_dashboard.class));
            return;
        }
        Student=findViewById(R.id.Student);
        Admin=findViewById(R.id.Admin);
        getSupportActionBar().hide();
        Student.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
             openActivity2();
            }

        });
        Admin.setOnClickListener(view -> {
            openActivity1();
        });
    }
    public void openActivity2(){
        Intent intent =new Intent(MainActivity.this,Sign_in.class);
        startActivity(intent);
    }
    public void openActivity1(){
        Intent intent =new Intent(this,admin_login.class);
        startActivity(intent);
    }
}