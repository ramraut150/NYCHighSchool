package com.ramraut.NYC_High_School.response;

import com.ramraut.NYC_High_School.model.School_Detail;
import java.util.List;

public class DetailResponse {

    public List<School_Detail> details;

    public List<School_Detail> getDetails() {
        return details;
    }

    public void setDetails(List<School_Detail> details) {
        this.details = details;
    }

}
