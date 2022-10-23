package com.hititcs.pegasusdcs.di.module;

import com.hititcs.pegasusdcs.di.scope.FlightDetailScope;
import com.hititcs.pegasusdcs.di.scope.FlightListScope;
import com.hititcs.pegasusdcs.di.scope.LoginScope;
import com.hititcs.pegasusdcs.view.barcode.ScanBarcodeActivity;
import com.hititcs.pegasusdcs.view.barcode.ScanBarcodeModule;
import com.hititcs.pegasusdcs.view.flight.FlightListActivity;
import com.hititcs.pegasusdcs.view.flight.FlightListModule;
import com.hititcs.pegasusdcs.view.flight.detail.FlightDetailActivity;
import com.hititcs.pegasusdcs.view.flight.detail.FlightDetailModule;
import com.hititcs.pegasusdcs.view.login.MainActivity;
import com.hititcs.pegasusdcs.view.login.MainModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

  @LoginScope
  @ContributesAndroidInjector(modules = MainModule.class)
  abstract MainActivity bindLoginActivity();

  @FlightListScope
  @ContributesAndroidInjector(modules = FlightListModule.class)
  abstract FlightListActivity bindFlightListActivity();

  @FlightDetailScope
  @ContributesAndroidInjector(modules = FlightDetailModule.class)
  abstract FlightDetailActivity bindFlightDetailActivity();

  @ContributesAndroidInjector(modules = ScanBarcodeModule.class)
  abstract ScanBarcodeActivity bindScanBarcodeActivity();

}
