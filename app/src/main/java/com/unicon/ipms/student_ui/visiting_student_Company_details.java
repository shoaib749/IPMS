package com.unicon.ipms.student_ui;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
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
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.unicon.ipms.R;
import com.unicon.ipms.constant;
import com.unicon.ipms.databinding.FragmentStudentCompanyDetailsFragmentBinding;
import com.unicon.ipms.databinding.StudentFragmentPlacementStatusBinding;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class visiting_student_Company_details extends Fragment {
    private  String c_name;
    private FragmentStudentCompanyDetailsFragmentBinding  binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding =  FragmentStudentCompanyDetailsFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        TextView TVdrive_date,TVeligi,TVbatch,TVsalary,TVc_name;
        TVdrive_date = binding.DriveDateET;
        TVeligi = binding.EligibilityCriteriaET;
        TVbatch = binding.BatchET;
        TVsalary = binding.SalaryET;
        TVc_name = binding.CompanyTV;
        Bundle bundle = this.getArguments();
        if(bundle != null){
            Toast.makeText(getContext(), "C_name"+bundle.getString("c_name"), Toast.LENGTH_SHORT).show();
            c_name = bundle.getString("c_name");
            ProgressDialog progressDialog = new ProgressDialog(getContext());
            progressDialog.setMessage("Loading...");
            progressDialog.show();
            StringRequest stringRequest = new StringRequest(
                    Request.Method.POST,
                    constant.URL_STUDENT_INDI_CURRENT_DRIVE,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            progressDialog.dismiss();
                            try {
                                JSONObject object = new JSONObject(response);
                                if(object.getBoolean("error")!=true){
                                    TVdrive_date.setText(object.getString("date_drive"));
                                    TVeligi.setText(object.getString("elig_crit"));
                                    TVbatch.setText(object.getString("batch"));
                                    TVsalary.setText(object.getString("sal_lpa"));
                                    TVc_name.setText(object.getString("c_name"));
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
                    return params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(getContext());
            requestQueue.add(stringRequest);

        }
//        return inflater.inflate(R.layout.fragment_student__company_details_fragment, container,  false);
          return binding.getRoot();
    }

}