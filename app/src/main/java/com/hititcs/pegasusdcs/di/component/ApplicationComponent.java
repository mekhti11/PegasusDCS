package com.hititcs.pegasusdcs.di.component;

import android.app.Application;

import com.hititcs.pegasusdcs.DcsApplication;
import com.hititcs.pegasusdcs.data.executer.JobExecutor;
import com.hititcs.pegasusdcs.data.shared.PreferenceHelper;
import com.hititcs.pegasusdcs.di.module.ActivityBuilder;
import com.hititcs.pegasusdcs.di.module.ApplicationModule;
import com.hititcs.pegasusdcs.di.module.CacheModule;
import com.hititcs.pegasusdcs.di.module.DataModule;
import com.hititcs.pegasusdcs.di.module.RemoteModule;
import com.hititcs.pegasusdcs.domain.executer.PostExecutionThread;
import com.hititcs.pegasusdcs.view.home.di.HomeModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
    AndroidSupportInjectionModule.class, ApplicationModule.class, ActivityBuilder.class,
    CacheModule.class, DataModule.class, RemoteModule.class,
//        BaggageTrackModule.class,
    HomeModule.class
})
public interface ApplicationComponent extends AndroidInjector<DaggerApplication> {

  @Override
  void inject(DaggerApplication instance);

  void inject(DcsApplication application);

  PostExecutionThread postExecutionThread();

  JobExecutor jobExecutor();

  PreferenceHelper preferenceHelper();

  @Component.Builder
  interface Builder {

    @BindsInstance
    Builder application(Application application);

    ApplicationComponent build();
  }
}
