package com.hititcs.pegasusdcs.data.login;

import com.hititcs.pegasusdcs.data.remote.LoginRemote;
import com.hititcs.pegasusdcs.domain.model.AuthModel;
import com.hititcs.pegasusdcs.domain.model.LoginRequest;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;

public class LoginRemoteDataStore implements LoginDataStore {

  private final LoginRemote loginRemote;

  @Inject
  public LoginRemoteDataStore(LoginRemote loginRemote) {
    this.loginRemote = loginRemote;
  }

  @Override
  public Single<AuthModel> login(LoginRequest loginRequest) {
    return loginRemote.login(loginRequest);
  }

  @Override
  public Completable saveAuth(AuthModel authModel) {
    throw new UnsupportedOperationException();
  }

  @Override
  public Completable clear() {
    throw new UnsupportedOperationException();
  }

  @Override
  public Single<Boolean> isCached() {
    throw new UnsupportedOperationException();
  }
}
