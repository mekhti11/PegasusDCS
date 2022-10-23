package com.hititcs.pegasusdcs.view.barcode;

import com.hititcs.pegasusdcs.domain.model.BoardingResponse;
import com.hititcs.pegasusdcs.view.LoadView;

public interface ScanBarcodeView extends LoadView {

    void showBarcodeResult(BoardingResponse data);

}
