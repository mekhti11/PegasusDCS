package com.hititcs.pegasusdcs.view.barcode;

import com.hititcs.pegasusdcs.domain.model.BoardWithBarcodeRequest;
import com.hititcs.pegasusdcs.view.LoadPresenter;

public interface ScanBarcodePresenter extends LoadPresenter<ScanBarcodeView> {

  void scanBarcode(BoardWithBarcodeRequest request,
                   ScanBarcodeFragment.BarcodeReadListener responseListener);
}
