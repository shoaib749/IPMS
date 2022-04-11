package com.unicon.ipms.student_ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.unicon.ipms.R;
import com.unicon.ipms.databinding.FragmentStudentAttendenceDetailsBinding;


public class student_attendence_details extends Fragment {
    FragmentStudentAttendenceDetailsBinding binding;
    TextView tvMyInternships;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        binding = FragmentStudentAttendenceDetailsBinding.inflate(inflater,container,false);
        tvMyInternships = binding.myInternshipTV;
        tvMyInternships.setOnClickListener(view -> {
            Fragment fragment = new student_my_Internships_fragment();
            FragmentManager fragmentManager = getParentFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(getParentFragment().getId(), fragment)
                    .commit();
        });
        return binding.getRoot();
    }
}