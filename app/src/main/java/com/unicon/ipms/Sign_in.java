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
                                //fetching more_info data and storing in sharefpref
                                getSharedMoreData();
                                startActivity(new Intent(getApplicationContext(),student_dashboard.class));
//                                Intent intent = new Intent(Sign_in.this,test_data.class);
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
    public void getSharedMoreData(){
        final String email = ET_email.getText().toString().trim();
        StringRequest stringRequest_1 = new StringRequest(
                Request.Method.POST,
                constant.URL_STUDENT_ALL_INFO,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject object = new JSONObject(response);
                            if(!object.getBoolean("error")){
                                sharepref_moreInfo.getInstance(getApplicationContext()).moreInfo_1(object.getString("fname"),
                                        object.getString("lname"),
                                        email,
                                        object.getString("mobNo"),
                                        object.getString("par_mobNo"),
                                        object.getString("dept"),
                                        object.getString("regNo"),
                                        object.getString("sem"));
                                sharepref_moreInfo.getInstance(getApplicationContext()).moreInfo2(
                                        object.getString("pass10"),
                                        object.getString("per10"),
                                        object.getString("pass12"),
                                        object.getString("per12"),
                                        object.getString("passDip"),
                                        object.getString("perDip")
                                );
                                sharepref_moreInfo.getInstance(getApplicationContext()).moreInfo3(
                                        object.getString("admission"),
                                        object.getString("sgpa1"),
                                        object.getString("sgpa2"),
                                        object.getString("sgpa3"),
                                        object.getString("sgpa4"),
                                        object.getString("sgpa5"),
                                        object.getString("sgpa6"),
                                        object.getString("sgpa7"),
                                        object.getString("sgpa8"),
                                        object.getString("avgSgpa"),
                                        object.getString("passout"),
                                        object.getString("live"),
                                        object.getString("dead")
                                );
                                sharepref_moreInfo.getInstance(getApplicationContext()).moreInfo4(
                                        object.getString("option1"),
                                        object.getString("placement_status"),
                                        object.getString("gap")
                                );
                                Toast.makeText(getApplicationContext(),"Scucces",Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(getApplicationContext(),"Some thing went wrong",Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(),"error"+e,Toast.LENGTH_LONG).show();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();
            }
        }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("email_id",email);
                return params;
            }
        };
        requestHandler.getInstance(getApplicationContext()).addToRequestQueue(stringRequest_1);
    }

}