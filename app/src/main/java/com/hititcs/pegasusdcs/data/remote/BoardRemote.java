package com.hititcs.pegasusdcs.data.remote;

import com.hititcs.pegasusdcs.domain.model.BoardWithBarcodeRequest;
import com.hititcs.pegasusdcs.domain.model.BoardingResponse;

import io.reactivex.Single;
import retrofit2.http.Body;

public interface BoardRemote {
    Single<BoardingResponse> withBarcode(BoardWithBarcodeRequest request);
}
