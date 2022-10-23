package com.hititcs.pegasusdcs.domain.interactor.boardpax;

import com.hititcs.pegasusdcs.domain.executer.PostExecutionThread;
import com.hititcs.pegasusdcs.domain.executer.ThreadExecutor;
import com.hititcs.pegasusdcs.domain.interactor.SingleWithParamUseCase;
import com.hititcs.pegasusdcs.domain.model.BoardWithBarcodeRequest;
import com.hititcs.pegasusdcs.domain.model.BoardingResponse;
import com.hititcs.pegasusdcs.domain.repository.BoardRepository;

import javax.inject.Inject;

import io.reactivex.Single;

public class BoardWithBarcodeUseCase extends SingleWithParamUseCase<BoardingResponse, BoardWithBarcodeRequest> {

    private final BoardRepository boardRepository;

    @Inject
    public BoardWithBarcodeUseCase(PostExecutionThread postExecutionThread,
                                   ThreadExecutor threadExecutor,
                                   BoardRepository boardRepository) {
        super(postExecutionThread, threadExecutor);
        this.boardRepository = boardRepository;
    }

    @Override
    protected Single<BoardingResponse> buildUseCaseObservable(BoardWithBarcodeRequest param) {
        return boardRepository.withBarcode(param);
    }
}
