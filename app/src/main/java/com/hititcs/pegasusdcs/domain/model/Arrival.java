package com.hititcs.pegasusdcs.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Arrival {
    @SerializedName("localTime")
    @Expose
    String localTime;
    @SerializedName("location")
    @Expose
    Location location;
    @SerializedName("segIsn")
    @Expose
    String segIsn;
    @SerializedName("segmentFigure")
    @Expose
    SegmentFigure segmentFigure;
    @SerializedName("utcTime")
    @Expose
    String utcTime;

    public String getLocalTime() {
        return localTime;
    }

    public void setLocalTime(String localTime) {
        this.localTime = localTime;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getSegIsn() {
        return segIsn;
    }

    public void setSegIsn(String segIsn) {
        this.segIsn = segIsn;
    }

    public SegmentFigure getSegmentFigure() {
        return segmentFigure;
    }

    public void setSegmentFigure(SegmentFigure segmentFigure) {
        this.segmentFigure = segmentFigure;
    }

    public String getUtcTime() {
        return utcTime;
    }

    public void setUtcTime(String utcTime) {
        this.utcTime = utcTime;
    }
}
