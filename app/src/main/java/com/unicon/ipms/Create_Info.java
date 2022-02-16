package com.unicon.ipms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Create_Info extends AppCompatActivity {
    private Button sub;
    private TextView Tv_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_info);
        sub = findViewById(R.id.submit);
        Tv_login = findViewById(R.id.have_account);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Create_Info.this,More_Info. class);
                startActivity(intent);
            }
        });
        Tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Create_Info.this,More_Info. class);
                startActivity(intent);
            }
        });
    }
}
