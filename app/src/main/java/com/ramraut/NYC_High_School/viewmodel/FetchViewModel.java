package com.ramraut.NYC_High_School.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.ramraut.NYC_High_School.model.School;
import com.ramraut.NYC_High_School.repository.SchoolRepository;

import java.util.List;

public class FetchViewModel extends AndroidViewModel {

    private SchoolRepository schoolRepository;
    private LiveData<List<School>> schoolResponseLiveData;

    public FetchViewModel(@NonNull Application application) {
        super(application);
        schoolRepository = new SchoolRepository();
        this.schoolResponseLiveData = schoolRepository.getSchoolLiveData();
    }

    public LiveData<List<School>> getSchoolResponseLiveData(){
        return schoolResponseLiveData;
    }


}
