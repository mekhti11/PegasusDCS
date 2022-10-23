package com.hititcs.pegasusdcs.domain.model;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {

  @SerializedName("token")
  private String token = null;

  public LoginResponse token(String token) {
    this.token = token;
    return this;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

}