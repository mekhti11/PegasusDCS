package com.hititcs.pegasusdcs.data.remote;

import com.hititcs.pegasusdcs.domain.model.AuthModel;
import com.hititcs.pegasusdcs.domain.model.LoginRequest;

import io.reactivex.Single;

public interface LoginRemote {

  Single<AuthModel> login(LoginRequest loginRequest);
}