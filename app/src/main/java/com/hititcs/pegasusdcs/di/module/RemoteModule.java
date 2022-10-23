package com.hititcs.pegasusdcs.di.module;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.hititcs.pegasusdcs.data.remote.BoardRemote;
import com.hititcs.pegasusdcs.data.remote.FlightRemote;
import com.hititcs.pegasusdcs.data.remote.LoginRemote;
import com.hititcs.pegasusdcs.data.shared.AuthManager;
import com.hititcs.pegasusdcs.remote.api.BoardingControllerApi;
import com.hititcs.pegasusdcs.remote.service.BoardRemoteImpl;
import com.hititcs.pegasusdcs.remote.service.FlightRemoteImpl;
import com.hititcs.pegasusdcs.remote.service.LoginRemoteImpl;
import com.hititcs.pegasusdcs.remote.ServiceCreator;
import com.hititcs.pegasusdcs.remote.api.FlightApi;
import com.hititcs.pegasusdcs.remote.api.UserApi;
import com.hititcs.pegasusdcs.remote.interceptors.TokenInterceptor;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class RemoteModule {

  @Provides
  public static UserApi provideUserApi(@Named("default") ServiceCreator serviceCreator) {
    return serviceCreator.createService(UserApi.class);
  }

  @Provides
  @Named("login")
  public static UserApi provideLoginServiceRx(@Named("token") ServiceCreator serviceCreator) {
    return serviceCreator.createService(UserApi.class);
  }

  @Provides
  @Singleton
  public static FlightApi provideFlightResourceApi(
      @Named("default") ServiceCreator serviceCreator) {
    return serviceCreator.createService(FlightApi.class);
  }
//
  @Provides
  @Singleton
  public static BoardingControllerApi provideBoardingControllerApi(
      @Named("default") ServiceCreator serviceCreator) {
    return serviceCreator.createService(BoardingControllerApi.class);
  }
//
//  @Provides
//  @Singleton
//  public static AirlineApi provideAirlineApi(@Named("default") ServiceCreator serviceCreator) {
//    return serviceCreator.createService(AirlineApi.class);
//  }
//
  @Provides
  @Singleton
  public static TokenInterceptor provideTokenInterceptor(AuthManager authManager) {
    return new TokenInterceptor(authManager);
  }

  @Provides
  @Singleton
  @Named("default")
  public static ServiceCreator serviceCreator(String apiUrl, @Named("deviceId") String deviceId,
      boolean debug,
      TokenInterceptor tokenInterceptor) {
    return new ServiceCreator(apiUrl, debug, deviceId, tokenInterceptor,
        new StethoInterceptor(), true);
  }

  @Provides
  @Singleton
  @Named("token")
  public static ServiceCreator provideTokenServiceCreator(String apiUrl,
      @Named("deviceId") String deviceId,
      boolean debug) {
    return new ServiceCreator(apiUrl, debug, deviceId, null, new StethoInterceptor(), false);
  }
//
  @Binds
  public abstract LoginRemote crewRemote(LoginRemoteImpl loginRemote);

  @Binds
  public abstract FlightRemote flightRemote(FlightRemoteImpl flightService);

  @Binds
  public abstract BoardRemote boardingRemote(BoardRemoteImpl boardingService);

//  @Binds
//  public abstract AirlineRemote airlineRemote(AirlineService airlineService);

}
