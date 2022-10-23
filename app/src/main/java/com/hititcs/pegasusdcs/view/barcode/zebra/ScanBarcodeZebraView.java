package com.hititcs.pegasusdcs.view.barcode.zebra;

import com.hititcs.pegasusdcs.domain.model.BoardingResponse;
import com.hititcs.pegasusdcs.view.LoadView;

public interface ScanBarcodeZebraView extends LoadView {
  void showBarcodeResult(BoardingResponse data);
}
