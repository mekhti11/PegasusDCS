package com.hititcs.pegasusdcs.data.cache;

import com.hititcs.pegasusdcs.domain.model.AuthModel;
import com.hititcs.pegasusdcs.domain.model.LoginRequest;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface LoginCache {

  Single<AuthModel> login(LoginRequest loginRequest);

  Completable saveAuth(AuthModel authModel);

  Completable clear();

  Single<Boolean> isCached();

}