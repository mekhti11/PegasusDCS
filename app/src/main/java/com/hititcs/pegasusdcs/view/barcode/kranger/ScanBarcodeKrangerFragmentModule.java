package com.hititcs.pegasusdcs.view.barcode.kranger;

import com.hititcs.pegasusdcs.domain.interactor.boardpax.BoardWithBarcodeUseCase;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class ScanBarcodeKrangerFragmentModule {
  @Provides
  static ScanBarcodeKrangerContract.ScanBarcodeKrangerPresenter provideScanBarcodeKrangerPresenter(
      ScanBarcodeKrangerContract.ScanBarcodeKrangerView scanBarcodeKrangerView,
      BoardWithBarcodeUseCase scanBarcodeUseCase) {
    return new ScanBarcodeKrangerPresenterImpl(scanBarcodeKrangerView, scanBarcodeUseCase);
  }

  @Binds
  abstract ScanBarcodeKrangerContract.ScanBarcodeKrangerView bindScanBarcodeKrangerView(
      ScanBarcodeKrangerFragment scanBarcodeKrangerFragment);
}
