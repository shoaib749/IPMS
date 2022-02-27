package com.unicon.ipms.student_ui.internships;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class InternshipsViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public InternshipsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Internship fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}