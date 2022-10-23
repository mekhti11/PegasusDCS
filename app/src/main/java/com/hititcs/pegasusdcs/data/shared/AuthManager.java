package com.hititcs.pegasusdcs.data.shared;

import com.hititcs.pegasusdcs.domain.model.AuthModel;

public interface AuthManager {

  void saveAuthModel(AuthModel authModel);

  AuthModel getAuthModel();

  String getAccessToken();

  void clear();

  boolean isContain();

}