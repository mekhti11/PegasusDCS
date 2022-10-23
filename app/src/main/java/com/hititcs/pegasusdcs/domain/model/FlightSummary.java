package com.hititcs.pegasusdcs.domain.model;

import com.google.gson.annotations.SerializedName;

public class FlightSummary {

  @SerializedName("airlineCode")
  private String airlineCode = null;

  @SerializedName("airlineIataCode")
  private String airlineIataCode = null;

  @SerializedName("airlineShortName")
  private String airlineShortName = null;

  @SerializedName("arrPort")
  private String arrPort = null;

  @SerializedName("arrTime")
  private String arrTime = null;

  @SerializedName("depPort")
  private String depPort = null;

  @SerializedName("depTime")
  private String depTime = null;

  @SerializedName("flightId")
  private String flightId = null;

  @SerializedName("flightNumber")
  private String flightNumber = null;

  @SerializedName("boardingGate")
  private String boardingGate;

  @SerializedName("boardingTime")
  private String boardingTime;

  @SerializedName("delayTime")
  private String delayTime;

  @SerializedName("flightStatus")
  private String flightStatus;

  private transient boolean isVisible = true;

  public FlightSummary airlineCode(String airlineCode) {
    this.airlineCode = airlineCode;
    return this;
  }

  public String getAirlineCode() {
    return airlineCode;
  }

  public void setAirlineCode(String airlineCode) {
    this.airlineCode = airlineCode;
  }

  public FlightSummary airlineIataCode(String airlineIataCode) {
    this.airlineIataCode = airlineIataCode;
    return this;
  }

  public String getAirlineIataCode() {
    return airlineIataCode;
  }

  public void setAirlineIataCode(String airlineIataCode) {
    this.airlineIataCode = airlineIataCode;
  }

  public FlightSummary airlineShortName(String airlineShortName) {
    this.airlineShortName = airlineShortName;
    return this;
  }


  public String getAirlineShortName() {
    return airlineShortName;
  }

  public void setAirlineShortName(String airlineShortName) {
    this.airlineShortName = airlineShortName;
  }

  public FlightSummary arrPort(String arrPort) {
    this.arrPort = arrPort;
    return this;
  }

  public String getArrPort() {
    return arrPort;
  }

  public void setArrPort(String arrPort) {
    this.arrPort = arrPort;
  }

  public FlightSummary arrTime(String arrTime) {
    this.arrTime = arrTime;
    return this;
  }

  public String getArrTime() {
    return arrTime;
  }

  public void setArrTime(String arrTime) {
    this.arrTime = arrTime;
  }

  public FlightSummary depPort(String depPort) {
    this.depPort = depPort;
    return this;
  }


  public String getDepPort() {
    return depPort;
  }

  public void setDepPort(String depPort) {
    this.depPort = depPort;
  }

  public FlightSummary depTime(String depTime) {
    this.depTime = depTime;
    return this;
  }

  public String getDepTime() {
    return depTime;
  }

  public void setDepTime(String depTime) {
    this.depTime = depTime;
  }

  public FlightSummary flightId(String flightId) {
    this.flightId = flightId;
    return this;
  }

  public String getFlightId() {
    return flightId;
  }

  public void setFlightId(String flightId) {
    this.flightId = flightId;
  }

  public FlightSummary flightNumber(String flightNumber) {
    this.flightNumber = flightNumber;
    return this;
  }

  public String getFlightNumber() {
    return flightNumber;
  }

  public void setFlightNumber(String flightNumber) {
    this.flightNumber = flightNumber;
  }

  public FlightSummary boardingGate(String boardingGate) {
    this.boardingGate = boardingGate;
    return this;
  }

  public String getBoardingGate() {
    return boardingGate;
  }

  public void setBoardingGate(String boardingGate) {
    this.boardingGate = boardingGate;
  }

  public FlightSummary boardingTime(String boardingTime) {
    this.boardingTime = boardingTime;
    return this;
  }

  public String getBoardingTime() {
    return boardingTime;
  }

  public void setBoardingTime(String boardingTime) {
    this.boardingTime = boardingTime;
  }

  public FlightSummary delayTime(String delayTime) {
    this.delayTime = delayTime;
    return this;
  }

  public String getDelayTime() {
    return delayTime;
  }

  public void setDelayTime(String delayTime) {
    this.delayTime = delayTime;
  }

  public boolean isVisible() {
    return isVisible;
  }

  public void setVisible(boolean visible) {
    isVisible = visible;
  }

  public String getFlightStatus() {
    if(flightStatus == null){
      return "";
    }
    return flightStatus;
  }

  public void setFlightStatus(String flightStatus) {
    this.flightStatus = flightStatus;
  }
}