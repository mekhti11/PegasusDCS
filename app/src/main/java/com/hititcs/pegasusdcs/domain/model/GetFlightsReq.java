package com.hititcs.pegasusdcs.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetFlightsReq {

    @SerializedName("depPort")
    @Expose
    String depPort ;
    @SerializedName("arrPort")
    @Expose
    String arrPort ;
    @SerializedName("schDeptDate")
    @Expose
    String schDeptDate;
    @SerializedName("aaCode")
    @Expose
    String aaCode;
    @SerializedName("flightNo")
    @Expose
    String flightNo;

    public String getDepPort() {
        return depPort;
    }

    public void setDepPort(String depPort) {
        this.depPort = depPort;
    }

    public String getArrPort() {
        return arrPort;
    }

    public void setArrPort(String arrPort) {
        this.arrPort = arrPort;
    }

    public String getSchDeptDate() {
        return schDeptDate;
    }

    public void setSchDeptDate(String schDeptDate) {
        this.schDeptDate = schDeptDate;
    }

    public String getAaCode() {
        return aaCode;
    }

    public void setAaCode(String aaCode) {
        this.aaCode = aaCode;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }
}
