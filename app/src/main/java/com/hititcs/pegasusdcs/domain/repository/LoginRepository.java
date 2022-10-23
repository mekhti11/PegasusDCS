package com.hititcs.pegasusdcs.domain.repository;

import com.hititcs.pegasusdcs.domain.model.AuthModel;
import com.hititcs.pegasusdcs.domain.model.LoginRequest;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface LoginRepository {

  Single<AuthModel> login(LoginRequest loginRequest);

  Completable saveAuth(AuthModel authModel);

  Completable clear();

}