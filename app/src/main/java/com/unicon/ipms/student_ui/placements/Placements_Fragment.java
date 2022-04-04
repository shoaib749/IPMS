package com.unicon.ipms.student_ui.placements;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.unicon.ipms.constant;
import com.unicon.ipms.databinding.StudentFragmentPlacementBinding;
import com.unicon.ipms.getAllDriveNamePlacementModel;
import com.unicon.ipms.requestHandler;
import com.unicon.ipms.student_ui.Adaptor.recyclerviewadaptor;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Placements_Fragment extends Fragment {

    private StudentFragmentPlacementBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = StudentFragmentPlacementBinding.inflate(inflater, container, false);
        RecyclerView company_list=binding.recyclerview;
        ArrayList<String> arr=new ArrayList<>();
        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST,
                constant.URL_STUDENT_ALL_CURRENT_DRIVE,null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        progressDialog.dismiss();
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject object = response.getJSONObject(i);
                                arr.add(object.getString("c_name"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                                progressDialog.dismiss();
                            }
                        }
                        company_list.setLayoutManager(new LinearLayoutManager(getContext()));
                        company_list.setAdapter(new recyclerviewadaptor(arr));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley", error.toString());
                progressDialog.dismiss();
            }
        }
        );
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(jsonArrayRequest);

        PlacementsViewModel placementsViewModel =
                new ViewModelProvider(this).get(PlacementsViewModel.class);

        View root = binding.getRoot();
        final TextView textView = binding.CompanyNameTV;
        placementsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}