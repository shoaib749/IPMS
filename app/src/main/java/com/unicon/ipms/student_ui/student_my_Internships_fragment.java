package com.unicon.ipms.student_ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.unicon.ipms.R;
import com.unicon.ipms.databinding.FragmentStudentMyInternshipsFragmentBinding;
import com.unicon.ipms.databinding.StudentFragmentInternshipsBinding;
import com.unicon.ipms.student_ui.Adaptor.myinternAdaptor;
import com.unicon.ipms.student_ui.Adaptor.recyclerviewadaptor;

public class student_my_Internships_fragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentStudentMyInternshipsFragmentBinding binding = FragmentStudentMyInternshipsFragmentBinding.inflate(inflater, container, false);
        RecyclerView company_list=binding.myInternshipLV;
        String[] list={"Capgemini","TCS","Infosys","Infocept","Persistent","Amazon","Google","Facebook"};
        String[] start={"10-09-2021","12-05-2021","-","-","-","-","-","-"};
        String[] end={"10-12-2021","12-08-2021","-","-","-","-","-","-"};
        company_list.setLayoutManager(new LinearLayoutManager(this.getContext()));
//        company_list.setAdapter(new myinternAdaptor(list,start,end));
        return binding.getRoot();
    }
}