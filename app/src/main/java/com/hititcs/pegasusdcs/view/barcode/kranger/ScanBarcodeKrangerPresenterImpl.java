package com.hititcs.pegasusdcs.view.barcode.kranger;

import com.hititcs.pegasusdcs.domain.interactor.boardpax.BoardWithBarcodeUseCase;
import com.hititcs.pegasusdcs.domain.model.BoardWithBarcodeRequest;
import com.hititcs.pegasusdcs.domain.model.BoardingResponse;
import com.hititcs.pegasusdcs.subscriber.SingleSubscriber;
import com.hititcs.pegasusdcs.util.MessageUtils;

public class ScanBarcodeKrangerPresenterImpl
    implements ScanBarcodeKrangerContract.ScanBarcodeKrangerPresenter {

  private final BoardWithBarcodeUseCase scanBarcodeUseCase;
  private ScanBarcodeKrangerContract.ScanBarcodeKrangerView scanBarcodeKrangerView;

  public ScanBarcodeKrangerPresenterImpl(
      ScanBarcodeKrangerContract.ScanBarcodeKrangerView scanBarcodeKrangerView,
      BoardWithBarcodeUseCase scanBarcodeUseCase) {
    this.scanBarcodeKrangerView = scanBarcodeKrangerView;
    this.scanBarcodeUseCase = scanBarcodeUseCase;
  }

  @Override
  public ScanBarcodeKrangerContract.ScanBarcodeKrangerView getView() {
    return scanBarcodeKrangerView;
  }

  @Override
  public void setView(ScanBarcodeKrangerContract.ScanBarcodeKrangerView view) {
    this.scanBarcodeKrangerView = view;
  }

  @Override
  public void dispose() {
    if (scanBarcodeUseCase != null) {
      scanBarcodeUseCase.dispose();
    }
  }

  @Override
  public void scanBarcode(BoardWithBarcodeRequest request,
                          ScanBarcodeKrangerFragment.ResponseListener<BoardingResponse> responseListener) {
    scanBarcodeKrangerView.showProgressDialog();
    scanBarcodeUseCase.execute(new SingleSubscriber<BoardingResponse>(this) {
      @Override
      public void onResponse(BoardingResponse data) {
        responseListener.onResponse(data);
        scanBarcodeKrangerView.hideProgressDialog();
      }

      @Override
      public void onError(Throwable e) {
        responseListener.onError(MessageUtils.getMessage(super.getErrorMessage(e)));
        scanBarcodeKrangerView.hideProgressDialog();
      }
    }, request);
  }
}
