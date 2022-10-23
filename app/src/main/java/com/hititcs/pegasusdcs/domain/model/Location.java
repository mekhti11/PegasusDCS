package com.hititcs.pegasusdcs.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location {
    @SerializedName("cityCode")
    @Expose
    String cityCode;
    @SerializedName("cityName")
    @Expose
    String cityName;
    @SerializedName("country")
    @Expose
    String country;
    @SerializedName("countryName")
    @Expose
    String countryName;
    @SerializedName("portCode")
    @Expose
    String portCode;
    @SerializedName("portName")
    @Expose
    String portName;
    @SerializedName("portNameDefault")
    @Expose
    String portNameDefault;
    @SerializedName("terminal")
    @Expose
    String terminal;

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getPortCode() {
        return portCode;
    }

    public void setPortCode(String portCode) {
        this.portCode = portCode;
    }

    public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }

    public String getPortNameDefault() {
        return portNameDefault;
    }

    public void setPortNameDefault(String portNameDefault) {
        this.portNameDefault = portNameDefault;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }
}
