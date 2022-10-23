package com.hititcs.pegasusdcs.remote.service;

import com.hititcs.pegasusdcs.data.remote.BoardRemote;
import com.hititcs.pegasusdcs.domain.model.BoardWithBarcodeRequest;
import com.hititcs.pegasusdcs.domain.model.BoardingResponse;
import com.hititcs.pegasusdcs.remote.api.BoardingControllerApi;

import javax.inject.Inject;

import io.reactivex.Single;

public class BoardRemoteImpl implements BoardRemote {

    private final BoardingControllerApi api;

    @Inject
    public BoardRemoteImpl(BoardingControllerApi api) {
        this.api = api;
    }


    @Override
    public Single<BoardingResponse> withBarcode(BoardWithBarcodeRequest request) {
        return api.withBarcode(request);
    }
}
