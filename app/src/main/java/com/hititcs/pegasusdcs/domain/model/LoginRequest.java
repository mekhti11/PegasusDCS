package com.hititcs.pegasusdcs.domain.model;

import com.google.gson.annotations.SerializedName;

public class LoginRequest {

  @SerializedName("password")
  private String password = null;

  @SerializedName("username")
  private String username = null;


  public LoginRequest password(String password) {
    this.password = password;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public LoginRequest username(String username) {
    this.username = username;
    return this;
  }

  public void setUsername(String username) {
    this.username = username;
  }
}

