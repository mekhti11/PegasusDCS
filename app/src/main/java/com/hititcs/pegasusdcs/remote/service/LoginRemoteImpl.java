package com.hititcs.pegasusdcs.remote.service;

import com.hititcs.pegasusdcs.data.remote.LoginRemote;
import com.hititcs.pegasusdcs.domain.model.AuthModel;
import com.hititcs.pegasusdcs.domain.model.LoginRequest;
import com.hititcs.pegasusdcs.remote.api.UserApi;
import com.hititcs.pegasusdcs.remote.mapper.MemberMapper;

import javax.inject.Inject;

import io.reactivex.Single;

public class LoginRemoteImpl implements LoginRemote {

  private final UserApi userControllerApi;
  private final MemberMapper memberMapper;

  @Inject
  public LoginRemoteImpl(UserApi userControllerApi, MemberMapper memberMapper) {
    this.userControllerApi = userControllerApi;
    this.memberMapper = memberMapper;
  }

  @Override
  public Single<AuthModel> login(LoginRequest loginRequest) {
    return userControllerApi.loginRx(loginRequest)
        .filter(loginResponse -> loginResponse != null)
        .toSingle()
        .map(memberMapper::mapToEntity);
  }
}