package com.unicon.ipms.Student_DashBoard_UI.Placement;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.unicon.ipms.databinding.StudentFragmentPlacementBinding;

public class HomeFragment extends Fragment {

    private StudentFragmentPlacementBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = StudentFragmentPlacementBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.VistingCompaniesTV;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}