package com.unicon.ipms.student_ui;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.unicon.ipms.R;
import com.unicon.ipms.constant;
import com.unicon.ipms.databinding.FragmentInternshipStudentCompanyDetailsBinding;
import com.unicon.ipms.sharepref_moreInfo;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class internship_student_company_details extends Fragment {
    private String c_name,batch;
    private FragmentInternshipStudentCompanyDetailsBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentInternshipStudentCompanyDetailsBinding.inflate(inflater,container,false);
        View root = binding.getRoot();
        TextView TVc_name,TVelgi,TVstart_date,TVduration,TVlink;
        TVc_name = binding.ICompanyTV;
        TVelgi = binding.IEligibilityCriteriaET;
        TVstart_date = binding.StartDateETInt;
        TVduration = binding.DurationET;
        TVlink = binding.RegLinkET;
        Bundle bundle = this.getArguments();
        if(bundle != null){
            c_name = bundle.getString("c_name");
            batch = sharepref_moreInfo.getInstance(getContext()).getpassout();
            ProgressDialog progressDialog = new ProgressDialog(getContext());
            progressDialog.setMessage("Loading...");
            progressDialog.show();
            StringRequest stringRequest = new StringRequest(
                    Request.Method.POST,
                    constant.URL_STUDENT_INTERNSHIP_CURRENT_DRIVE,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            progressDialog.dismiss();
                            try {
                                JSONObject object = new JSONObject(response);
                                if(object.getBoolean("error")!=true){
                                    TVc_name.setText(object.getString("c_name"));
                                    TVduration.setText(object.getString("duration"));
                                    TVelgi.setText(object.getString("el_criteria"));
                                    TVlink.setText(object.getString("reg_link"));
                                    TVstart_date.setText(object.getString("date_start"));

                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                                Toast.makeText(getContext(), "error"+e, Toast.LENGTH_LONG).show();
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getContext(),error.getMessage(),Toast.LENGTH_LONG).show();
                    progressDialog.dismiss();
                }
            }
            ){
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> params = new HashMap<>();
                    params.put("c_name",c_name);
                    params.put("batch",batch);
                    return params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(getContext());
            requestQueue.add(stringRequest);
        }
//        return inflater.inflate(R.layout.fragment_internship_student_company_details, container, false);
        return binding.getRoot();
    }
}