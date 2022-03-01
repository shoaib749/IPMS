package com.unicon.ipms.student_ui.placements;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.unicon.ipms.constant;
import com.unicon.ipms.databinding.StudentFragmentPlacementBinding;
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
        String[] list = new String[100];
//        String[] list={"Capgemini","TCS","Infosys","Infocept","Persistent","Amazon","Google","Facebook"};
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                constant.URL_STUDENT_ALL_CURRENT_DRIVE,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                               JSONArray array = new JSONArray(response);
                               JSONObject object =null;
                               for(int i=0;i<array.length();i++){
                                   object = array.getJSONObject(i);
                                   String c_name = object.getString("c_name");
                                   Toast.makeText(getContext(),object.getString("c_name"),Toast.LENGTH_LONG).show();
                                   list[i] = c_name;
                               }
                               Toast.makeText(getContext(),object.getString("c_name"),Toast.LENGTH_LONG).show();
                                   


                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getContext(),"error"+e,Toast.LENGTH_LONG).show();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                return params;
            }
        };
        requestHandler.getInstance(getContext()).addToRequestQueue(stringRequest);
        company_list.setLayoutManager(new LinearLayoutManager(this.getContext()));
        company_list.setAdapter(new recyclerviewadaptor(list));

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