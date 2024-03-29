package com.unicon.ipms.admin_ui.placements;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.unicon.ipms.databinding.AdminFragmentPlacementsBinding;


public class Placements_Fragment extends Fragment {

    private PlacementsViewModel mViewModel;
    private AdminFragmentPlacementsBinding binding;

    public static Placements_Fragment newInstance() {
        return new Placements_Fragment();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mViewModel =
                new ViewModelProvider(this).get(PlacementsViewModel.class);

        binding = AdminFragmentPlacementsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textPlacements;
        mViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }


}