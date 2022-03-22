package com.ramraut.NYC_High_School.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class School {
    @SerializedName("dbn")
    @Expose
    String dbn;

    @SerializedName("school_name")
    @Expose
    String school_name;

    public String getDbn() {
        return dbn;
    }

    public String getSchool_name() {
        return school_name;
    }
}
