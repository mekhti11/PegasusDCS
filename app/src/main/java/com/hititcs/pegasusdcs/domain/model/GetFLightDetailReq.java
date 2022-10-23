package com.hititcs.pegasusdcs.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetFLightDetailReq {
    @SerializedName("legIsn")
    @Expose
    private String legIsn;

    public String getLegIsn() {
        return legIsn;
    }

    public void setLegIsn(String legIsn) {
        this.legIsn = legIsn;
    }
}
