package com.unicon.ipms;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Sign_in extends AppCompatActivity {
    private Button login;
    private TextView sign;
    private EditText ET_password,ET_email;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        getSupportActionBar().hide();

        login = (Button) findViewById(R.id.sign_in);
        ET_email = (EditText) findViewById(R.id.login_username);
        ET_password = (EditText) findViewById(R.id.login_password);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait....");

        sign=findViewById(R.id.sign);
        try {
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        userLogin();
                }
            });
        }catch (Exception e){
            Toast.makeText(this, "error"+e, Toast.LENGTH_LONG).show();
        }


        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Sign_in.this,Create_Info.class);
                startActivity(intent);
            }
        });

    }

    private void userLogin() {
        final String email = ET_email.getText().toString().trim();
        final String password = ET_password.getText().toString().trim();
        progressDialog.show();
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                constant.URL_LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        try {
                            JSONObject jsonObject  = new JSONObject(response);
                            if(!jsonObject.getBoolean("error")){
                               sharedPrefManager.getInstance(getApplicationContext())
                               .userLogin(
                                       jsonObject.getString("fname"),
                                       jsonObject.getString("lname"),
                                       jsonObject.getString("email_id")
                               );
                                Toast.makeText(Sign_in.this, "User Login successfully", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(Sign_in.this, jsonObject.getString("message"), Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(Sign_in.this, "Request time out. Check your connection", Toast.LENGTH_LONG).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(Sign_in.this, error.getMessage()+" ", Toast.LENGTH_LONG).show();
            }
        }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("email_id",email);
                params.put("pass",password);
                return params;
            }
        };
        requestHandler.getInstance(this).addToRequestQueue(stringRequest);
    }

}