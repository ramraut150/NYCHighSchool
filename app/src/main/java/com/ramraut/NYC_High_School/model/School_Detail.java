package com.ramraut.NYC_High_School.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class School_Detail extends School{



    @SerializedName("sat_critical_reading_avg_score")
    @Expose
    private String sat_critical_reading_avg_score;

    @SerializedName("sat_math_avg_score")
    @Expose
    private String sat_math_avg_score;

    @SerializedName("sat_writing_avg_score")
    @Expose
    private String sat_writing_avg_score;

    //****************************************************************************************
    public String getSat_critical_reading_avg_score() {
        return sat_critical_reading_avg_score;
    }

    public void setSat_critical_reading_avg_score(String sat_critical_reading_avg_score) {
        this.sat_critical_reading_avg_score = sat_critical_reading_avg_score;
    }

    public String getSat_math_avg_score() {
        return sat_math_avg_score;
    }

    public void setSat_math_avg_score(String sat_math_avg_score) {
        this.sat_math_avg_score = sat_math_avg_score;
    }

    public String getSat_writing_avg_score() {
        return sat_writing_avg_score;
    }

    public void setSat_writing_avg_score(String sat_writing_avg_score) {
        this.sat_writing_avg_score = sat_writing_avg_score;
    }


    @Override
    public String toString() {
        return "School_Detail{" +
                "sat_critical_reading_avg_score='" + sat_critical_reading_avg_score + '\'' +
                ", sat_math_avg_score='" + sat_math_avg_score + '\'' +
                ", sat_writing_avg_score='" + sat_writing_avg_score + '\'' +
                '}';
    }
}
