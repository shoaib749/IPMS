package com.unicon.ipms.student_ui.placements;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PlacementsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PlacementsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("COMPANY NAME");
    }

    public LiveData<String> getText() {
        return mText;
    }
}