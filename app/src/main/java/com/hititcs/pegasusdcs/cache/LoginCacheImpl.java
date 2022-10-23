package com.hititcs.pegasusdcs.cache;

import com.hititcs.pegasusdcs.data.cache.LoginCache;
import com.hititcs.pegasusdcs.data.shared.AuthManager;
import com.hititcs.pegasusdcs.domain.model.AuthModel;
import com.hititcs.pegasusdcs.domain.model.LoginRequest;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;

public class LoginCacheImpl implements LoginCache {

  private final AuthManager authManager;

  @Inject
  public LoginCacheImpl(AuthManager authManager) {
    this.authManager = authManager;
  }

  @Override
  public Single<AuthModel> login(LoginRequest loginRequest) {
    return Single.defer(() -> Single.just(authManager.getAuthModel()))
        .filter(authModel -> authModel != null)
        .toSingle();
  }

  @Override
  public Completable saveAuth(AuthModel authModel) {
    return Completable.defer(() -> {
      authManager.saveAuthModel(authModel);
      return Completable.complete();
    });
  }

  @Override
  public Completable clear() {
    return Completable.defer(() -> {
      authManager.clear();
      return Completable.complete();
    });
  }

  @Override
  public Single<Boolean> isCached() {
    return Single
        .defer(() -> Single.just(authManager.isContain()));
  }
}
