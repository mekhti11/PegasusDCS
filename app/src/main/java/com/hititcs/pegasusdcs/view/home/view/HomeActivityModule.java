package com.hititcs.pegasusdcs.view.home.view;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class HomeActivityModule {
//  @ContributesAndroidInjector(modules = BaggageTrackScanFragmentModule.class)
//  abstract BaggageTrackScanFragment baggageTrackScanFragment();

  @ContributesAndroidInjector(modules = HomeFragmentModule.class)
  abstract HomeFragment bindHomeFragment();
}
