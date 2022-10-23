package com.hititcs.pegasusdcs.data.login;

import com.hititcs.pegasusdcs.data.cache.LoginCache;
import com.hititcs.pegasusdcs.domain.model.AuthModel;
import com.hititcs.pegasusdcs.domain.model.LoginRequest;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;

public class LoginCacheDataStore implements LoginDataStore {

  private final LoginCache loginCache;

  @Inject
  public LoginCacheDataStore(LoginCache loginCache) {
    this.loginCache = loginCache;
  }

  @Override
  public Single<AuthModel> login(LoginRequest loginRequest) {
    return loginCache.login(loginRequest);
  }

  @Override
  public Completable saveAuth(AuthModel authModel) {
    return loginCache.saveAuth(authModel);
  }

  @Override
  public Completable clear() {
    return loginCache.clear();
  }

  @Override
  public Single<Boolean> isCached() {
    return loginCache.isCached();
  }
}
