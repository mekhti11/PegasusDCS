package com.hititcs.pegasusdcs.view.barcode;

import com.hititcs.pegasusdcs.domain.interactor.boardpax.BoardWithBarcodeUseCase;
import com.hititcs.pegasusdcs.domain.model.BoardWithBarcodeRequest;
import com.hititcs.pegasusdcs.domain.model.BoardingResponse;
import com.hititcs.pegasusdcs.subscriber.SingleSubscriber;
import com.hititcs.pegasusdcs.util.MessageUtils;

public class ScanBarcodePresenterImpl implements ScanBarcodePresenter {

  private ScanBarcodeView scanBarcodeView;
  private final BoardWithBarcodeUseCase scanBarcodeUseCase;

  public ScanBarcodePresenterImpl(ScanBarcodeView scanBarcodeView, BoardWithBarcodeUseCase scanBarcodeUseCase) {
    this.scanBarcodeView = scanBarcodeView;
    this.scanBarcodeUseCase = scanBarcodeUseCase;
  }

  @Override
  public ScanBarcodeView getView() {
    return scanBarcodeView;
  }

  @Override
  public void setView(ScanBarcodeView view) {
    this.scanBarcodeView = view;
  }

  @Override
  public void dispose() {
    if (scanBarcodeUseCase != null) {
      scanBarcodeUseCase.dispose();
    }
  }

  @Override
  public void scanBarcode(BoardWithBarcodeRequest request,
                          ScanBarcodeFragment.BarcodeReadListener responseListener) {
//    scanBarcodeView.showProgressDialog();
    scanBarcodeUseCase.execute(new SingleSubscriber<BoardingResponse>(this) {
      @Override
      public void onResponse(BoardingResponse data) {
        responseListener.onResponse(data);
        scanBarcodeView.hideProgressDialog();
      }

      @Override
      public void onError(Throwable e) {
        responseListener.onError(super.getErrorMessage(e));
        scanBarcodeView.hideProgressDialog();
      }
    }, request);
  }
}
