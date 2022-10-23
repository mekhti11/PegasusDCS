package com.hititcs.pegasusdcs.data.repository;

import com.hititcs.pegasusdcs.data.remote.BoardRemote;
import com.hititcs.pegasusdcs.domain.model.BoardWithBarcodeRequest;
import com.hititcs.pegasusdcs.domain.model.BoardingResponse;
import com.hititcs.pegasusdcs.domain.repository.BoardRepository;

import javax.inject.Inject;

import io.reactivex.Single;

public class BoardRepositoryImpl implements BoardRepository {

    private final BoardRemote boardRemote;

    @Inject
    public BoardRepositoryImpl(BoardRemote boardRemote) {
        this.boardRemote = boardRemote;
    }

    @Override
    public Single<BoardingResponse> withBarcode(BoardWithBarcodeRequest request) {
        return boardRemote.withBarcode(request);
    }
}
