package com.unicon.ipms.ui.placements;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PlacementsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PlacementsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Placements fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}