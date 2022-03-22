package com.ramraut.NYC_High_School.retrofit;

import com.ramraut.NYC_High_School.model.School;
import com.ramraut.NYC_High_School.model.School_Detail;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiRequest {

    //for school name
    @GET("s3k6-pzi2.json")
    Call<List<School>> getSchoolRecords();

    //for sat score
    @GET("f9bf-2cp4.json")
    Call<List<School_Detail>> getSatRecord(
            @Query("dbn") String dbn
    );
}


