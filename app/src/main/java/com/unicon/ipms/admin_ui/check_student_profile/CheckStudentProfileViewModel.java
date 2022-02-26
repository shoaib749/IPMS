package com.unicon.ipms.admin_ui.check_student_profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CheckStudentProfileViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public CheckStudentProfileViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is check student details fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}