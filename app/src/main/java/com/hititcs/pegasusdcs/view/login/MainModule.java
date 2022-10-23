package com.hititcs.pegasusdcs.view.login;

import com.hititcs.pegasusdcs.domain.executer.PostExecutionThread;
import com.hititcs.pegasusdcs.domain.executer.ThreadExecutor;
import com.hititcs.pegasusdcs.domain.interactor.login.LoginUseCase;
import com.hititcs.pegasusdcs.domain.repository.LoginRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
    @Provides
    static LoginUseCase provideLoginUseCase(LoginRepository loginRepository, PostExecutionThread postExecutionThread,
                                            ThreadExecutor threadExecutor) {
        return new LoginUseCase(loginRepository, postExecutionThread, threadExecutor);
    }
}
