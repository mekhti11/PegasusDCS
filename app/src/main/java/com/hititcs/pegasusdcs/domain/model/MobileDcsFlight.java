package com.hititcs.pegasusdcs.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MobileDcsFlight {
    @SerializedName("aaCode")
    @Expose
    String aaCode;
    @SerializedName("arrivalList")
    @Expose
    List<Arrival> arrivalList;
    @SerializedName("boardingGate")
    @Expose
    String boardingGate;
    @SerializedName("boardingTime")
    @Expose
    String boardingTime;
    @SerializedName("delayTime")
    @Expose
    String delayTime;
    @SerializedName("departure")
    @Expose
    Departure departure;
    @SerializedName("flightNo")
    @Expose
    String flightNo;
    @SerializedName("legIsn")
    @Expose
    String legIsn;
    @SerializedName("status")
    @Expose
    String status;
    @SerializedName("equipmentType")
    @Expose
    Equipmenttype equipmenttype;

    public Equipmenttype getEquipmentType() {
        return equipmenttype;
    }

    public void setEquipmentType(Equipmenttype equipmenttype) {
        this.equipmenttype = equipmenttype;
    }

    public String getAaCode() {
        return aaCode;
    }

    public void setAaCode(String aaCode) {
        this.aaCode = aaCode;
    }

    public List<Arrival> getArrivalList() {
        return arrivalList;
    }

    public void setArrivalList(List<Arrival> arrivalList) {
        this.arrivalList = arrivalList;
    }

    public String getBoardingGate() {
        return boardingGate;
    }

    public void setBoardingGate(String boardingGate) {
        this.boardingGate = boardingGate;
    }

    public String getBoardingTime() {
        return boardingTime;
    }

    public void setBoardingTime(String boardingTime) {
        this.boardingTime = boardingTime;
    }

    public String getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(String delayTime) {
        this.delayTime = delayTime;
    }

    public Departure getDeparture() {
        return departure;
    }

    public void setDeparture(Departure departure) {
        this.departure = departure;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getLegIsn() {
        return legIsn;
    }

    public void setLegIsn(String legIsn) {
        this.legIsn = legIsn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
