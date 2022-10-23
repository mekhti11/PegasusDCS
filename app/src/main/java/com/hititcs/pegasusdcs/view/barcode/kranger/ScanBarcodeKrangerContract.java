package com.hititcs.pegasusdcs.view.barcode.kranger;

import com.hititcs.pegasusdcs.domain.model.BoardWithBarcodeRequest;
import com.hititcs.pegasusdcs.domain.model.BoardingResponse;
import com.hititcs.pegasusdcs.view.LoadPresenter;
import com.hititcs.pegasusdcs.view.LoadView;

public interface ScanBarcodeKrangerContract {

  interface ScanBarcodeKrangerPresenter extends LoadPresenter<ScanBarcodeKrangerView> {
    void scanBarcode(BoardWithBarcodeRequest request,
                     ScanBarcodeKrangerFragment.ResponseListener<BoardingResponse> responseListener);
  }

  interface ScanBarcodeKrangerView extends LoadView {
    void showBarcodeResult(BoardingResponse data);
  }
}
