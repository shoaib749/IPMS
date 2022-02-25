package com.unicon.ipms.ui.add_placement_details;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AddPlacementDetailsViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public AddPlacementDetailsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is add placement details fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}