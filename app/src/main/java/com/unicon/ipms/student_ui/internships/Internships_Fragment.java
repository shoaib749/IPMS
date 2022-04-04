package com.unicon.ipms.student_ui.internships;

import androidx.lifecycle.ViewModelProvider;

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
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.unicon.ipms.R;
import com.unicon.ipms.constant;
import com.unicon.ipms.databinding.StudentFragmentHomeBinding;
import com.unicon.ipms.databinding.StudentFragmentInternshipsBinding;
import com.unicon.ipms.databinding.StudentFragmentPlacementBinding;
import com.unicon.ipms.student_ui.Adaptor.recyclerviewadaptor;
import com.unicon.ipms.student_ui.home.HomeViewModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Internships_Fragment extends Fragment {

    private StudentFragmentInternshipsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        InternshipsViewModel internshipsViewModel =
                new ViewModelProvider(this).get(InternshipsViewModel.class);
        getActivity().setTitle("Your actionbar title");
        binding = StudentFragmentInternshipsBinding.inflate(inflater, container, false);
        RecyclerView company_list=binding.recyclerviewIntern;
        ArrayList<String> arr=new ArrayList<>();
        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST,
                constant.URL_STUDENT_ALL_INTERNSHIP_DRIVE,null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        progressDialog.dismiss();
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject object = response.getJSONObject(i);
                                arr.add(object.getString("company_name"));
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
//        arr.add("Capgemini");
//        arr.add("TCS");
//        arr.add("Infosys");
//        arr.add("Infocept");
//        arr.add("Capgemini");
//        arr.add("TCS");
//        arr.add("Infosys");
//        arr.add("Infocept");
//        arr.add("Capgemini");
//        arr.add("TCS");
//        arr.add("Infosys");
//        arr.add("Infocept");
//        arr.add("Capgemini");
//        arr.add("TCS");
//        arr.add("Infosys");
//        arr.add("Infocept");
//      String[] list={"Capgemini","TCS","Infosys","Infocept","Persistent","Amazon","Google","Facebook"};
        company_list.setLayoutManager(new LinearLayoutManager(this.getContext()));
        company_list.setAdapter(new recyclerviewadaptor(arr));

        View root = binding.getRoot();

        final TextView textView = binding.InternshipsOppurtunitiesTV;
        internshipsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}