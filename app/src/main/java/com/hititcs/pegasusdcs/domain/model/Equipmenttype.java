package com.hititcs.pegasusdcs.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Equipmenttype {

    @SerializedName("acReg")
    @Expose
    String acReg;
    @SerializedName("airEquipType")
    @Expose
    String airEquipType;
    @SerializedName("airEquipTypeModel")
    @Expose
    String airEquipTypeModel;

    public String getAcReg() {
        return acReg;
    }

    public void setAcReg(String acReg) {
        this.acReg = acReg;
    }

    public String getAirEquipType() {
        return airEquipType;
    }

    public void setAirEquipType(String airEquipType) {
        this.airEquipType = airEquipType;
    }

    public String getAirEquipTypeModel() {
        return airEquipTypeModel;
    }

    public void setAirEquipTypeModel(String airEquipTypeModel) {
        this.airEquipTypeModel = airEquipTypeModel;
    }
}
