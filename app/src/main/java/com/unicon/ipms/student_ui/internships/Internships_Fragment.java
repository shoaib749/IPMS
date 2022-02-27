package com.unicon.ipms.student_ui.internships;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.unicon.ipms.R;
import com.unicon.ipms.databinding.StudentFragmentHomeBinding;
import com.unicon.ipms.databinding.StudentFragmentInternshipsBinding;
import com.unicon.ipms.student_ui.home.HomeViewModel;

public class Internships_Fragment extends Fragment {

    private StudentFragmentInternshipsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        InternshipsViewModel internshipsViewModel =
                new ViewModelProvider(this).get(InternshipsViewModel.class);

        binding = StudentFragmentInternshipsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textStudentInt;
        internshipsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}