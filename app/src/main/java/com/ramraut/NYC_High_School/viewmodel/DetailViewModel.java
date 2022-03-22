package com.ramraut.NYC_High_School.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.ramraut.NYC_High_School.model.School_Detail;
import com.ramraut.NYC_High_School.repository.SchoolRepository;

import java.util.List;

public class DetailViewModel extends AndroidViewModel {

    private SchoolRepository schoolRepository;

    public DetailViewModel(@NonNull Application application) {
        super(application);
        schoolRepository = new SchoolRepository();
    }

    public LiveData<List<School_Detail>> getDetailResponseLiveData(String dbn){
        return schoolRepository.getDetailLiveData(dbn);
    }

}