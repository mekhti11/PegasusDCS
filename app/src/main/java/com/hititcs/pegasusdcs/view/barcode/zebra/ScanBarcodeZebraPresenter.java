package com.hititcs.pegasusdcs.view.barcode.zebra;

import com.hititcs.pegasusdcs.domain.model.BoardWithBarcodeRequest;
import com.hititcs.pegasusdcs.domain.model.BoardingResponse;
import com.hititcs.pegasusdcs.view.LoadPresenter;

public interface ScanBarcodeZebraPresenter extends LoadPresenter<ScanBarcodeZebraView> {
  void scanBarcode(BoardWithBarcodeRequest request,
                   ScanBarcodeZebraFragment.ResponseListener<BoardingResponse> responseListener);
}
