package com.unicon.ipms;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

public class More_info_4 extends AppCompatActivity {
    private Button submit;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info4);
        progressDialog = new ProgressDialog(this);

//        submit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                sendData();
//            }
//        });
    }
//    public void getData(){
//        String option1,placement_status,gap;
//        sharepref_moreInfo.getInstance(getApplicationContext())
//                .moreInfo4(option1,placement_status,gap);
//    }
//    public void sendData(){
//        progressDialog.setMessage("Submitting...");
//        progressDialog.show();
//        StringRequest stringRequest = new StringRequest(
//                Request.Method.POST,
//                constant.URL_MOREINFO,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        progressDialog.dismiss();
//                        try {
//                            JSONObject obj = new JSONObject(response);
//                            Toast.makeText(More_info_4.this,obj.getString("message") , Toast.LENGTH_SHORT).show();
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                            Toast.makeText(More_info_4.this, "error1"+e, Toast.LENGTH_SHORT).show();
//                        }
//
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                    progressDialog.hide();
//                    Toast.makeText(More_info_4.this, error.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        }){
//            @Nullable
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String,String> params = new HashMap<>();
//                params.put("fname",sharepref_moreInfo.getInstance(getApplicationContext()).getfname());
//                params.put("lname",sharepref_moreInfo.getInstance(getApplicationContext()).getlname());
//                params.put("email_id",sharepref_moreInfo.getInstance(getApplicationContext()).getemail());
//                params.put("mobNo",sharepref_moreInfo.getInstance(getApplicationContext()).getstudentNo());
//                params.put("par_mobNo",sharepref_moreInfo.getInstance(getApplicationContext()).getparentsNo());
//                params.put("dept",sharepref_moreInfo.getInstance(getApplicationContext()).getdept());
//                params.put("regNo",sharepref_moreInfo.getInstance(getApplicationContext()).getregistration());
//                params.put("pass10",sharepref_moreInfo.getInstance(getApplicationContext()).getpass10());
//                params.put("per10",sharepref_moreInfo.getInstance(getApplicationContext()).getper10());
//                params.put("pass12",sharepref_moreInfo.getInstance(getApplicationContext()).getpass12());
//                params.put("per12",sharepref_moreInfo.getInstance(getApplicationContext()).getper12());
//                params.put("passDip",sharepref_moreInfo.getInstance(getApplicationContext()).getpassDip());
//                params.put("perDip",sharepref_moreInfo.getInstance(getApplicationContext()).getperDip());
//                params.put("admission",sharepref_moreInfo.getInstance(getApplicationContext()).getadmission());
//                params.put("sgpa1",sharepref_moreInfo.getInstance(getApplicationContext()).getsgpa1());
//                params.put("sgpa2",sharepref_moreInfo.getInstance(getApplicationContext()).getsgpa2());
//                params.put("sgpa3",sharepref_moreInfo.getInstance(getApplicationContext()).getsgpa3());
//                params.put("sgpa4",sharepref_moreInfo.getInstance(getApplicationContext()).getsgpa4());
//                params.put("sgpa5",sharepref_moreInfo.getInstance(getApplicationContext()).getsgpa5());
//                params.put("sgpa6",sharepref_moreInfo.getInstance(getApplicationContext()).getsgpa6());
//                params.put("sgpa7",sharepref_moreInfo.getInstance(getApplicationContext()).getsgpa7());
//                params.put("sgpa8",sharepref_moreInfo.getInstance(getApplicationContext()).getsgpa8());
//                params.put("avgSpga",sharepref_moreInfo.getInstance(getApplicationContext()).getavgSgpa());
//                params.put("passout",sharepref_moreInfo.getInstance(getApplicationContext()).getpassout());
//                params.put("live",sharepref_moreInfo.getInstance(getApplicationContext()).getlive());
//                params.put("dead",sharepref_moreInfo.getInstance(getApplicationContext()).getdead());
//                params.put("option1",sharepref_moreInfo.getInstance(getApplicationContext()).getoption1());
//                params.put("placement_status",sharepref_moreInfo.getInstance(getApplicationContext()).getplacement_status());
//                params.put("gap",sharepref_moreInfo.getInstance(getApplicationContext()).getgap());
//                return params;
//            }
//        };
//        requestHandler.getInstance(this).addToRequestQueue(stringRequest);
//    }
}