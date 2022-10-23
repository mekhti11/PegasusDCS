package com.hititcs.pegasusdcs.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SegmentFigure {
    @SerializedName("totalBoardedPassenger")
    @Expose
    int totalBoardedPassenger;
    @SerializedName("totalCheckedPassenger")
    @Expose
    int totalCheckedPassenger;
    @SerializedName("totalChild")
    @Expose
    int totalChild;
    @SerializedName("totalFemale")
    @Expose
    int totalFemale;
    @SerializedName("totalInfant")
    @Expose
    int totalInfant;
    @SerializedName("totalMale")
    @Expose
    int totalMale;
    @SerializedName("totalPassenger")
    @Expose
    int totalPassenger;
    @SerializedName("totalUnboardedPassenger")
    @Expose
    int totalUnboardedPassenger;

    public int getTotalBoardedPassenger() {
        return totalBoardedPassenger;
    }

    public void setTotalBoardedPassenger(int totalBoardedPassenger) {
        this.totalBoardedPassenger = totalBoardedPassenger;
    }

    public int getTotalCheckedPassenger() {
        return totalCheckedPassenger;
    }

    public void setTotalCheckedPassenger(int totalCheckedPassenger) {
        this.totalCheckedPassenger = totalCheckedPassenger;
    }

    public int getTotalChild() {
        return totalChild;
    }

    public void setTotalChild(int totalChild) {
        this.totalChild = totalChild;
    }

    public int getTotalFemale() {
        return totalFemale;
    }

    public void setTotalFemale(int totalFemale) {
        this.totalFemale = totalFemale;
    }

    public int getTotalInfant() {
        return totalInfant;
    }

    public void setTotalInfant(int totalInfant) {
        this.totalInfant = totalInfant;
    }

    public int getTotalMale() {
        return totalMale;
    }

    public void setTotalMale(int totalMale) {
        this.totalMale = totalMale;
    }

    public int getTotalPassenger() {
        return totalPassenger;
    }

    public void setTotalPassenger(int totalPassenger) {
        this.totalPassenger = totalPassenger;
    }

    public int getTotalUnboardedPassenger() {
        return totalUnboardedPassenger;
    }

    public void setTotalUnboardedPassenger(int totalUnboardedPassenger) {
        this.totalUnboardedPassenger = totalUnboardedPassenger;
    }
}
