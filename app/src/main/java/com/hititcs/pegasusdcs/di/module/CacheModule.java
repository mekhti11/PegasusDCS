package com.hititcs.pegasusdcs.di.module;

import com.google.gson.Gson;
import com.hititcs.pegasusdcs.cache.AuthManagerImpl;
import com.hititcs.pegasusdcs.cache.LoginCacheImpl;
import com.hititcs.pegasusdcs.data.cache.LoginCache;
import com.hititcs.pegasusdcs.data.shared.AuthManager;
import com.hititcs.pegasusdcs.data.shared.PreferenceHelper;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class CacheModule {

  @Provides
  static AuthManager provideAuthManager(PreferenceHelper preferenceHelper, Gson gson) {
    return new AuthManagerImpl(preferenceHelper, gson);
  }

  @Binds
  public abstract LoginCache crewCache(LoginCacheImpl loginCache);


}
