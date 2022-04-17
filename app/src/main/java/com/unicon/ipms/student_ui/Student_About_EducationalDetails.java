package com.unicon.ipms.student_ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.unicon.ipms.R;
import com.unicon.ipms.databinding.FragmentStudentAboutEducationalDetailsBinding;
import com.unicon.ipms.sharepref_moreInfo;


public class Student_About_EducationalDetails extends Fragment {
    private FragmentStudentAboutEducationalDetailsBinding binding;
    TextView username,name,mobNo,par_mobNo,dept,sem,year_10,per_10,year_12,year_Dip,per_dip,reg_no,sem1,sem2,sem3,sem4,sem5,sem6,sem7,sem8,admision_year;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentStudentAboutEducationalDetailsBinding.inflate(inflater,container,false);
        username=binding.TVUsername;
        name=binding.TVname;
        mobNo=binding.TVstudentNumber;
        par_mobNo=binding.TVparentsMobile;
        dept=binding.TVdept;
        sem=binding.TVsem;
        year_10=binding.TV10Year;
        year_12=binding.TV12Year;
        per_10=binding.TV10Per;
        per_dip=binding.TVDipPer;
        year_Dip=binding.TVDipYear;
        sem1=binding.TVsem1;
        sem2=binding.TVsem2;
        sem3=binding.TVsem3;
        sem4=binding.TVsem4;
        sem5=binding.TVsem5;
        sem6=binding.TVsem6;
        sem7=binding.TVsem7;
        sem8=binding.TVsem8;
        reg_no=binding.TVregistrationNo;
        admision_year=binding.TVadmissionYear;

        username.setText(sharepref_moreInfo.getInstance(getContext()).getemail());
        name.setText(sharepref_moreInfo.getInstance(getContext()).getfname()+" "+sharepref_moreInfo.getInstance(getContext()).getlname());
        sem.setText(sharepref_moreInfo.getInstance(getContext()).getsemester());
        year_10.setText(sharepref_moreInfo.getInstance(getContext()).getpass10());
        year_12.setText(sharepref_moreInfo.getInstance(getContext()).getpass12());
        year_Dip.setText(sharepref_moreInfo.getInstance(getContext()).getpassDip());
        sem1.setText(sharepref_moreInfo.getInstance(getContext()).getsgpa1());
        sem2.setText(sharepref_moreInfo.getInstance(getContext()).getsgpa2());
        sem3.setText(sharepref_moreInfo.getInstance(getContext()).getsgpa3());
        sem4.setText(sharepref_moreInfo.getInstance(getContext()).getsgpa4());
        sem5.setText(sharepref_moreInfo.getInstance(getContext()).getsgpa5());
        sem6.setText(sharepref_moreInfo.getInstance(getContext()).getsgpa6());
        sem7.setText(sharepref_moreInfo.getInstance(getContext()).getsgpa7());
        sem8.setText(sharepref_moreInfo.getInstance(getContext()).getsgpa8());
        reg_no.setText(sharepref_moreInfo.getInstance(getContext()).getregistration());
        admision_year.setText(sharepref_moreInfo.getInstance(getContext()).getadmission());
        dept.setText(sharepref_moreInfo.getInstance(getContext()).getdept());
        per_10.setText(sharepref_moreInfo.getInstance(getContext()).getper10());
        per_dip.setText(sharepref_moreInfo.getInstance(getContext()).getperDip());
        mobNo.setText(sharepref_moreInfo.getInstance(getContext()).getstudentNo());
        par_mobNo.setText(sharepref_moreInfo.getInstance(getContext()).getparentsNo());
        View root = binding.getRoot();

//        return inflater.inflate(R.layout.fragment_student__about__educational_details, container, false);
        return root;
    }
}