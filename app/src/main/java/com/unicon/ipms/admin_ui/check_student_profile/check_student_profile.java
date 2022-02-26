package com.unicon.ipms.admin_ui.check_student_profile;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.unicon.ipms.databinding.FragmentCheckStudentProfileBinding;

public class check_student_profile extends Fragment {
    private FragmentCheckStudentProfileBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CheckStudentProfileViewModel checkStudentProfileViewModel =
                new ViewModelProvider(this).get(CheckStudentProfileViewModel.class);

        binding =FragmentCheckStudentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textCheckStudentProfile;
        checkStudentProfileViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}