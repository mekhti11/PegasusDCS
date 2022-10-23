package com.hititcs.pegasusdcs.view.barcode;

import com.hititcs.pegasusdcs.domain.interactor.boardpax.BoardWithBarcodeUseCase;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class ScanBarcodeFragmentModule {

    @Provides
    static ScanBarcodePresenter provideScanBarcodePresenter(ScanBarcodeView scanBarcodeView, BoardWithBarcodeUseCase scanBarcodeUseCase) {
        return new ScanBarcodePresenterImpl(scanBarcodeView, scanBarcodeUseCase);
    }

    @Binds
    abstract ScanBarcodeView bindScanBarcodeView(ScanBarcodeFragment scanBarcodeFragment);

}
