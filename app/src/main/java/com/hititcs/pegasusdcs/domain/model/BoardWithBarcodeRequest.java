package com.hititcs.pegasusdcs.domain.model;

import com.google.gson.annotations.SerializedName;

public class BoardWithBarcodeRequest {

  @SerializedName("barcodeContent")
  private String barcode = null;

  @SerializedName("legIsn")
  private String legIsn = null;

  public BoardWithBarcodeRequest barcode(String barcode, String flightId) {
    this.barcode = barcode;
    this.legIsn = flightId;
    return this;
  }

  public String getBarcode() {
    return barcode;
  }

  public void setBarcode(String barcode) {
    this.barcode = barcode;
  }

  public String getFlightId() {
    return legIsn;
  }

  public void setFlightId(String flightId) {
    this.legIsn = flightId;
  }
}

