package com.hititcs.pegasusdcs.view.home.di;

import com.hititcs.pegasusdcs.view.home.view.HomeActivity;
import com.hititcs.pegasusdcs.view.home.view.HomeActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class HomeModule {
  @ContributesAndroidInjector(modules = HomeActivityModule.class)
  abstract HomeActivity bindHomeActivity();
}