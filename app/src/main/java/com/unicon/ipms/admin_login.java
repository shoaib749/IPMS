package com.unicon.ipms;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class admin_login extends AppCompatActivity {
    private EditText ET_email_id,ET_pass;
    private Button B_login;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        getSupportActionBar().hide();

        ET_email_id = (EditText) findViewById(R.id.login_username);
        ET_pass = (EditText) findViewById(R.id.login_password);
        B_login = (Button) findViewById(R.id.sign_in);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait....");
        B_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();
            }
        });
    }
    public void getData(){
        String email_id,pass;
        email_id = ET_email_id.getText().toString().trim();
        pass = ET_pass.getText().toString().trim();
        progressDialog.show();
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                constant.URL_ADMIN_LOGIN, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();
                try {
                    JSONObject object = new JSONObject(response);
                    if(!object.getBoolean("error")){
                        Toast.makeText(admin_login.this, "User Login successful", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(admin_login.this,object.getString("message"),Toast.LENGTH_LONG).show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(admin_login.this,"error1"+e,Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.hide();
                Toast.makeText(admin_login.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("email_id",email_id);
                params.put("pass",pass);
                return params;
            }
        };
        requestHandler.getInstance(this).addToRequestQueue(stringRequest);
    }
}