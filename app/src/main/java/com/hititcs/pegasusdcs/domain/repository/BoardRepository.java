package com.hititcs.pegasusdcs.domain.repository;

import com.hititcs.pegasusdcs.domain.model.BoardWithBarcodeRequest;
import com.hititcs.pegasusdcs.domain.model.BoardingResponse;

import io.reactivex.Single;
import retrofit2.http.Body;

public interface BoardRepository {
    Single<BoardingResponse> withBarcode( BoardWithBarcodeRequest request);
}
