package com.unicon.ipms.student_ui.placement_status;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PlacementStatusViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public PlacementStatusViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Placement Status fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}