package com.ramraut.NYC_High_School.repository;

import androidx.lifecycle.MutableLiveData;
import com.ramraut.NYC_High_School.model.School;
import com.ramraut.NYC_High_School.model.School_Detail;
import com.ramraut.NYC_High_School.retrofit.ApiRequest;
import com.ramraut.NYC_High_School.retrofit.RetrofitRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SchoolRepository {

    private final ApiRequest apiRequest;
    private School school = new School();

    public SchoolRepository() {
        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
    }

    public MutableLiveData<List<School>> getSchoolLiveData() {
        MutableLiveData<List<School>> school = new MutableLiveData<>();

        apiRequest.getSchoolRecords().enqueue(new Callback<List<School>>() {
            @Override
            public void onResponse(Call<List<School>> call, Response<List<School>> response) {
                //if success
                if (response.body() != null) {

                    school.setValue(response.body());

                }
            }

            @Override
            public void onFailure(Call<List<School>> call, Throwable t) {
                school.setValue(null);
            }
        });


        return school;
    }


    public MutableLiveData<List<School_Detail>> getDetailLiveData(String dbn){
        MutableLiveData<List<School_Detail>> detail = new MutableLiveData<>();
        apiRequest.getSatRecord(dbn).enqueue(new Callback<List<School_Detail>>() { //getSatRecord(db)
            @Override
            public void onResponse(Call<List<School_Detail>> call, Response<List<School_Detail>> response) {
                //if success
                try{
                if(response.body() != null){

                    detail.setValue(response.body());


                }

                }catch (Exception e){

                }
            }

            @Override
            public void onFailure(Call<List<School_Detail>> call, Throwable t) {
                detail.setValue(null);
            }
        });

        return detail;
    }



}



