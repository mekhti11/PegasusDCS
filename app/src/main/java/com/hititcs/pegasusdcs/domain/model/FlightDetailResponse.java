package com.hititcs.pegasusdcs.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FlightDetailResponse {
    @SerializedName("mobileDcsFlight")
    @Expose
    MobileDcsFlight mobileDcsFlight;

    public MobileDcsFlight getMobileDcsFlight() {
        return mobileDcsFlight;
    }

    public void setMobileDcsFlight(MobileDcsFlight mobileDcsFlight) {
        this.mobileDcsFlight = mobileDcsFlight;
    }
}
