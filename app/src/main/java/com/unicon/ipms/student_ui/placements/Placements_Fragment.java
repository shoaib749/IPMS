package com.unicon.ipms.student_ui.placements;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.unicon.ipms.databinding.StudentFragmentPlacementBinding;
import com.unicon.ipms.student_ui.Adaptor.recyclerviewadaptor;

public class Placements_Fragment extends Fragment {

    private StudentFragmentPlacementBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = StudentFragmentPlacementBinding.inflate(inflater, container, false);
        RecyclerView company_list=binding.recyclerview;
        String[] list={"Capgemini","TCS","Infosys","Infocept","Persistent","Amazon","Google","Facebook"};
        company_list.setLayoutManager(new LinearLayoutManager(this.getContext()));
        company_list.setAdapter(new recyclerviewadaptor(list));

        PlacementsViewModel placementsViewModel =
                new ViewModelProvider(this).get(PlacementsViewModel.class);

        View root = binding.getRoot();
        final TextView textView = binding.CompanyNameTV;
        placementsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}