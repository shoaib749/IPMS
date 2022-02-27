package com.unicon.ipms.student_ui.placements;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
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
import com.unicon.ipms.databinding.StudentFragmentPlacementBinding;
import com.unicon.ipms.student_ui.home.HomeViewModel;
import com.unicon.ipms.student_ui.placement_status.PlacementStatusViewModel;

public class Placements_Fragment extends Fragment {

    private StudentFragmentPlacementBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PlacementsViewModel placementsViewModel =
                new ViewModelProvider(this).get(PlacementsViewModel.class);

        binding = StudentFragmentPlacementBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textStudentPlacement;
        placementsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}