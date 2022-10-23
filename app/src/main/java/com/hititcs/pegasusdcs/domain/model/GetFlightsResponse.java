package com.hititcs.pegasusdcs.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetFlightsResponse {
    @SerializedName("departingFlightList")
    @Expose
    List<DepartingFlight> departingFlightList;

    public List<DepartingFlight> getDepartingFlightList() {
        return departingFlightList;
    }

    public void setDepartingFlightList(List<DepartingFlight> departingFlightList) {
        this.departingFlightList = departingFlightList;
    }
}
