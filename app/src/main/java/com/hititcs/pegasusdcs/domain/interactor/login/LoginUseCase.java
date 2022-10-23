package com.hititcs.pegasusdcs.domain.interactor.login;

import com.hititcs.pegasusdcs.domain.executer.PostExecutionThread;
import com.hititcs.pegasusdcs.domain.executer.ThreadExecutor;
import com.hititcs.pegasusdcs.domain.interactor.SingleWithParamUseCase;
import com.hititcs.pegasusdcs.domain.model.AuthModel;
import com.hititcs.pegasusdcs.domain.model.LoginRequest;
import com.hititcs.pegasusdcs.domain.repository.LoginRepository;

import javax.inject.Inject;

import io.reactivex.Single;

public class LoginUseCase extends SingleWithParamUseCase<AuthModel, LoginRequest> {

  LoginRepository loginRepository;

  @Inject
  public LoginUseCase(LoginRepository loginRepository, PostExecutionThread postExecutionThread,
      ThreadExecutor threadExecutor) {
    super(postExecutionThread, threadExecutor);
    this.loginRepository = loginRepository;
  }

  @Override
  protected Single<AuthModel> buildUseCaseObservable(LoginRequest param) {
    if (param == null) {
      return Single.error(new NullPointerException("LoginModel request null"));
    }
    return loginRepository.login(param);
  }
}