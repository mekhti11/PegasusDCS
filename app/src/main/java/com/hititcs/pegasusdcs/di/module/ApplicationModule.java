package com.hititcs.pegasusdcs.di.module;

import android.app.Application;
import android.content.Context;
import android.provider.Settings;

import com.google.gson.Gson;
import com.hititcs.pegasusdcs.BuildConfig;
import com.hititcs.pegasusdcs.UIThread;
import com.hititcs.pegasusdcs.cache.PreferenceHelperImpl;
import com.hititcs.pegasusdcs.data.executer.JobExecutor;
import com.hititcs.pegasusdcs.data.shared.PreferenceHelper;
import com.hititcs.pegasusdcs.domain.executer.PostExecutionThread;
import com.hititcs.pegasusdcs.domain.executer.ThreadExecutor;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class ApplicationModule {

  @Provides
  @Singleton
  static PostExecutionThread providePostExecutionThread(UIThread uiThread) {
    return uiThread;
  }

  @Provides
  @Singleton
  static ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
    return jobExecutor;
  }

  @Provides
  @Singleton
  static boolean provideDebug() {
    return BuildConfig.DEBUG;
  }

  @Provides
  @Singleton
  static String provideApiUrl() {
    return BuildConfig.API_BASE_URL;
  }

  @Provides
  @Singleton
  static Gson provideGson() {
    return new Gson();
  }

  @Provides
  @Singleton
  static PreferenceHelper providePreferenceHelper(Context context) {
    return new PreferenceHelperImpl(context);
  }

  @Provides
  @Singleton
  @Named("deviceId")
  static String provideDeviceId(Context context) {
    return Settings.Secure.getString(context.getContentResolver(),
        Settings.Secure.ANDROID_ID);
  }

  @Binds
  abstract Context bindContext(Application application);
}
