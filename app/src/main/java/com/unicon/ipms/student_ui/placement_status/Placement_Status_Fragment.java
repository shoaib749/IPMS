package com.unicon.ipms.student_ui.placement_status;

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
import com.unicon.ipms.databinding.StudentFragmentPlacementStatusBinding;
import com.unicon.ipms.student_ui.home.HomeViewModel;
import com.unicon.ipms.student_ui.placements.PlacementsViewModel;

public class Placement_Status_Fragment extends Fragment {

    private StudentFragmentPlacementStatusBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        getActivity().setTitle("Placement Status");
        PlacementStatusViewModel placementStatusViewModel =
                new ViewModelProvider(this).get(PlacementStatusViewModel.class);

        binding =  StudentFragmentPlacementStatusBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textStudentPlacementStatus;
        placementStatusViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}