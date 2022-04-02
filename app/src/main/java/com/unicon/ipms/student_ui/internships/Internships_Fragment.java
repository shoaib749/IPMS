package com.unicon.ipms.student_ui.internships;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.unicon.ipms.R;
import com.unicon.ipms.databinding.StudentFragmentHomeBinding;
import com.unicon.ipms.databinding.StudentFragmentInternshipsBinding;
import com.unicon.ipms.databinding.StudentFragmentPlacementBinding;
import com.unicon.ipms.student_ui.Adaptor.recyclerviewadaptor;
import com.unicon.ipms.student_ui.home.HomeViewModel;

public class Internships_Fragment extends Fragment {

    private StudentFragmentInternshipsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        InternshipsViewModel internshipsViewModel =
                new ViewModelProvider(this).get(InternshipsViewModel.class);
        getActivity().setTitle("Your actionbar title");
        binding = StudentFragmentInternshipsBinding.inflate(inflater, container, false);
        RecyclerView company_list=binding.recyclerviewIntern;
        String[] list={"Capgemini","TCS","Infosys","Infocept","Persistent","Amazon","Google","Facebook"};
        company_list.setLayoutManager(new LinearLayoutManager(this.getContext()));
        company_list.setAdapter(new recyclerviewadaptor(list));

        View root = binding.getRoot();

        final TextView textView = binding.InternshipsOppurtunitiesTV;
        internshipsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}