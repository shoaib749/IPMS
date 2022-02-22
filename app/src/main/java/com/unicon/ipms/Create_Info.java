package com.unicon.ipms;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Create_Info extends AppCompatActivity {
    private Button submit;
    private EditText ET_fname,ET_lname,ET_email,ET_pass,ET_confirm_pass;
    private TextView TV_login;
    ProgressDialog progressDialog;
    Functions f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_info);

        ET_fname = (EditText) findViewById(R.id.First_Name);
        ET_lname = (EditText) findViewById(R.id.Last_Name);
        ET_email = (EditText) findViewById(R.id.editTextTextPersonName3);
        ET_pass = (EditText) findViewById(R.id.Password);
        ET_confirm_pass = (EditText) findViewById(R.id.Confirm_Password);
        progressDialog = new ProgressDialog(this);
        submit = (Button) findViewById(R.id.submit);
        TV_login = (TextView)findViewById(R.id.have_account);
        f=new Functions();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validations());
                    else{
                    userRegister();
                }


            }
        });
        TV_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Create_Info.this,Sign_in.class);
                startActivity(intent);
                finish();
            }
        });

    }
    public void userRegister(){
        String fname = ET_fname.getText().toString().trim();
        String lname = ET_lname.getText().toString().trim();
        String email = ET_email.getText().toString().trim();
        String pass = ET_pass.getText().toString().trim();
        String confirm_pass = ET_confirm_pass.getText().toString().trim();
        progressDialog.setMessage("Registering user....");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, constant.URL_REGISTER, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if(jsonObject.getBoolean("error") == false)
                    {
                        Intent intent = new Intent(Create_Info.this, More_Info.class);
                        startActivity(intent);
                        Toast.makeText(Create_Info.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    else{
                        Toast.makeText(Create_Info.this,jsonObject.getString("message"), Toast.LENGTH_LONG).show();
                    }

//                    Toast.makeText(Create_Info.this, jsonObject.getString("message"), Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.hide();
                Toast.makeText(Create_Info.this, error.getMessage(), Toast.LENGTH_LONG).show();

            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("fname",fname);
                params.put("lname",lname);
                params.put("email_id",email);
                params.put("pass",pass);
                return params;
            }
        };
            requestHandler.getInstance(this).addToRequestQueue(stringRequest);
    }
        private boolean validations()
        {

            /*FIRST NAME*/
            if (!f.isStringOnlyAlphabet(ET_fname.getText().toString())) {
                if (TextUtils.isEmpty(ET_fname.getText().toString()))
                {
                    Toast.makeText(Create_Info.this, "First Name cannot be empty", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(Create_Info.this, "First Name can only contain alphabets", Toast.LENGTH_LONG).show();
                }

                return true;
            }
            else if (f.invalidNoOfChars(ET_fname.getText().toString(),16))
            {
                Toast.makeText(Create_Info.this, "First Name cannot contain more than 16 alphabets", Toast.LENGTH_LONG).show();
                return  true;
            }
            /*LAST NAME*/
            if (!f.isStringOnlyAlphabet(ET_lname.getText().toString())) {
                if (TextUtils.isEmpty(ET_lname.getText().toString()))
                {
                    Toast.makeText(Create_Info.this, "Last Name cannot be empty", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(Create_Info.this, "Last Name can only contain alphabets", Toast.LENGTH_LONG).show();
                }
                return true;
            }
            else if (f.invalidNoOfChars(ET_lname.getText().toString(),16))
            {
                Toast.makeText(Create_Info.this, "Last Name cannot contain more than 16 alphabets", Toast.LENGTH_LONG).show();
                return  true;
            }
            /*Email NAME*/
            if(!f.invalidEmail(ET_email.getText().toString()))
            {
                Toast.makeText(Create_Info.this, "Invalid Email", Toast.LENGTH_LONG).show();
                return  true;
            }
            return false;

        }
    }