package com.unicon.ipms.student_ui;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.unicon.ipms.databinding.FragmentStudentMyInternshipsFragmentBinding;
import com.unicon.ipms.databinding.StudentFragmentInternshipsBinding;
import com.unicon.ipms.getStudentPlacementSalModel;
import com.unicon.ipms.myIntenshipDateModel;
import com.unicon.ipms.sharedPrefManager;
import com.unicon.ipms.student_ui.Adaptor.myinternAdaptor;
import com.unicon.ipms.student_ui.Adaptor.recyclerviewadaptor;
import com.unicon.ipms.student_ui.Adaptor.yourplaceAdaptor;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class student_my_Internships_fragment extends Fragment {
    List<myIntenshipDateModel> model_list = new ArrayList<myIntenshipDateModel>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentStudentMyInternshipsFragmentBinding binding = FragmentStudentMyInternshipsFragmentBinding.inflate(inflater, container, false);
        RecyclerView recyclerView=binding.myInternshipLV;
        ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                constant.URL_STUDENT_INTENSHIP_DATE,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        JSONArray response1;
                        try {
                            response1= new JSONArray(response);
                            for(int i=0;i<response1.length();i++){
                                JSONObject object = response1.getJSONObject(i);
                                myIntenshipDateModel model = new myIntenshipDateModel();
                                model.setCompany_name(object.getString("company_name"));
                                model.setStart_date(object.getString("start_date"));
                                model.setEnd_date(object.getString("end_date"));
                                model_list.add(model);

                            }

                        } catch (JSONException e) {
                            progressDialog.dismiss();
                            e.printStackTrace();
                        }
                        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                        recyclerView.setAdapter(new myinternAdaptor(getContext(),model_list));
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(getContext(),"error"+error.getMessage(),Toast.LENGTH_LONG).show();
            }
        }
        ) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("email_id", sharedPrefManager.getInstance(getContext()).getEmail());
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
        return binding.getRoot();
    }
}