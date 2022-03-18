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
import com.unicon.ipms.databinding.StudentFragmentInternshipsBinding;
import com.unicon.ipms.student_ui.Adaptor.myinternAdaptor;
import com.unicon.ipms.student_ui.Adaptor.recyclerviewadaptor;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link student_my_Internships_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class student_my_Internships_fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public student_my_Internships_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment student_my_Internships_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static student_my_Internships_fragment newInstance(String param1, String param2) {
        student_my_Internships_fragment fragment = new student_my_Internships_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        @NonNull StudentFragmentInternshipsBinding binding = StudentFragmentInternshipsBinding.inflate(inflater, container, false);
        RecyclerView company_list=binding.recyclerviewIntern;
        String[] list={"Capgemini","TCS","Infosys","Infocept","Persistent","Amazon","Google","Facebook"};
        String[] start={"10-09-2021","12-05-2021","-","-","-","-","-","-"};
        String[] end={"10-12-2021","12-08-2021","-","-","-","-","-","-"};
        company_list.setLayoutManager(new LinearLayoutManager(this.getContext()));
        company_list.setAdapter(new myinternAdaptor(list,start,end));
        return inflater.inflate(R.layout.fragment_student_my__internships_fragment, container, false);
    }
}