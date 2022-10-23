package com.hititcs.pegasusdcs.data.repository;

import com.hititcs.pegasusdcs.data.login.LoginDataStoreFactory;
import com.hititcs.pegasusdcs.domain.model.AuthModel;
import com.hititcs.pegasusdcs.domain.model.LoginRequest;
import com.hititcs.pegasusdcs.domain.repository.LoginRepository;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;

public class LoginDataRepository implements LoginRepository {

  LoginDataStoreFactory factory;

  @Inject
  public LoginDataRepository(LoginDataStoreFactory factory) {
    this.factory = factory;
  }

  @Override
  public Single<AuthModel> login(LoginRequest loginRequest) {
    return factory.getCrewCacheDataStore()
        .isCached()
        .flatMap(aBoolean -> factory.getDataStore(aBoolean).login(loginRequest))
        .filter(authModel -> authModel != null)
        .flatMapSingle(authModel -> saveAuth(authModel).toSingle(() -> authModel));
  }

  @Override
  public Completable saveAuth(AuthModel authModel) {
    return factory.getCrewCacheDataStore().saveAuth(authModel);
  }

  @Override
  public Completable clear() {
    return factory.getCrewCacheDataStore().clear();
  }
}