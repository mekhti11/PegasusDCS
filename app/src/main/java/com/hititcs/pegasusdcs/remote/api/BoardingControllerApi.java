package com.hititcs.pegasusdcs.remote.api;

import com.hititcs.pegasusdcs.domain.model.BoardWithBarcodeRequest;
import com.hititcs.pegasusdcs.domain.model.BoardingResponse;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface BoardingControllerApi {

  @POST("boarding/board-pax")
  Single<BoardingResponse> withBarcode(@Body BoardWithBarcodeRequest request);
}