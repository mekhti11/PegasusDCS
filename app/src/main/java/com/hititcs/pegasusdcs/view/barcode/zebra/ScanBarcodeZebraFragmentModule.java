package com.hititcs.pegasusdcs.view.barcode.zebra;

import com.hititcs.pegasusdcs.domain.interactor.boardpax.BoardWithBarcodeUseCase;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class ScanBarcodeZebraFragmentModule {
  @Provides
  static ScanBarcodeZebraPresenter provideScanBarcodeZebraPresenter(
      ScanBarcodeZebraView scanBarcodeZebraView, BoardWithBarcodeUseCase scanBarcodeUseCase) {
    return new ScanBarcodeZebraPresenterImpl(scanBarcodeZebraView, scanBarcodeUseCase);
  }

  @Binds
  abstract ScanBarcodeZebraView bindScanBarcodeZebraView(
      ScanBarcodeZebraFragment scanBarcodeZebraFragment);
}
