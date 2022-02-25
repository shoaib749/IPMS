package com.unicon.ipms.ui.internships;

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
import com.unicon.ipms.databinding.FragmentInternshipsBinding;
import com.unicon.ipms.databinding.FragmentPlacementsBinding;
import com.unicon.ipms.ui.placements.PlacementsViewModel;

public class Internships_Fragment extends Fragment {

    private InternshipsViewModel mViewModel;
    private FragmentInternshipsBinding binding;

    public static Internships_Fragment newInstance() {
        return new Internships_Fragment();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mViewModel =
                new ViewModelProvider(this).get(InternshipsViewModel.class);

        binding = FragmentInternshipsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textInternships;
        mViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

}