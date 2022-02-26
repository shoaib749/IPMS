package com.unicon.ipms.admin_ui.add_placement_details;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.unicon.ipms.databinding.FragmentAddPlacementDetailsBinding;

public class add_placement_details extends Fragment {

    private FragmentAddPlacementDetailsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AddPlacementDetailsViewModel addPlacementDetailsViewModel =
                new ViewModelProvider(this).get(AddPlacementDetailsViewModel.class);

        binding =FragmentAddPlacementDetailsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textAddPlacementDetails;
        addPlacementDetailsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}