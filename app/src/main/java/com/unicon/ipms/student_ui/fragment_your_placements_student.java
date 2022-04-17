package com.unicon.ipms.student_ui;

import android.app.ProgressDialog;
import android.os.Bundle;

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
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.unicon.ipms.R;
import com.unicon.ipms.constant;
import com.unicon.ipms.databinding.FragmentYourPlacementsStudentBinding;
import com.unicon.ipms.getStudentPlacementSalModel;
import com.unicon.ipms.sharedPrefManager;
import com.unicon.ipms.student_ui.Adaptor.yourplaceAdaptor;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class fragment_your_placements_student extends Fragment {
    List<getStudentPlacementSalModel> model_list = new ArrayList<getStudentPlacementSalModel>();


    private FragmentYourPlacementsStudentBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentYourPlacementsStudentBinding.inflate(inflater,container,false);
        RecyclerView recyclerView;
        recyclerView = binding.RVyourPlacementStudent;
        ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                constant.URL_STUDENT_PLACEMENT_SAL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        JSONArray response1;
                        try {
                            response1= new JSONArray(response);
                            for(int i=0;i<response1.length();i++){
                                JSONObject object = response1.getJSONObject(i);
                                getStudentPlacementSalModel model = new getStudentPlacementSalModel();
                                model.setC_name(object.getString("company_name"));
                                model.setSalary(object.getString("sal_lpa"));
                                Log.e("Val",object.getString("company_name"));
                                model_list.add(model);

                            }

                        } catch (JSONException e) {
                            progressDialog.dismiss();
                            e.printStackTrace();
                        }
                        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                        recyclerView.setAdapter(new yourplaceAdaptor(getContext(),model_list));
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
        View root = binding.getRoot();
        return root;
    }
}