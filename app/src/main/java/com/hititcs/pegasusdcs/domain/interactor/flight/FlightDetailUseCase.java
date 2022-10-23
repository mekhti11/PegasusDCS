package com.hititcs.pegasusdcs.domain.interactor.flight;

import com.hititcs.pegasusdcs.domain.executer.PostExecutionThread;
import com.hititcs.pegasusdcs.domain.executer.ThreadExecutor;
import com.hititcs.pegasusdcs.domain.interactor.SingleWithParamUseCase;
import com.hititcs.pegasusdcs.domain.model.FlightDetailResponse;
import com.hititcs.pegasusdcs.domain.model.GetFLightDetailReq;
import com.hititcs.pegasusdcs.domain.repository.FlightRepository;

import javax.inject.Inject;

import io.reactivex.Single;

public class FlightDetailUseCase extends SingleWithParamUseCase<FlightDetailResponse,GetFLightDetailReq> {

    private final FlightRepository flightRepository;

    @Inject
    public FlightDetailUseCase(PostExecutionThread postExecutionThread,
                               ThreadExecutor threadExecutor,
                               FlightRepository flightRepository) {
        super(postExecutionThread, threadExecutor);
        this.flightRepository = flightRepository;
    }

    @Override
    protected Single<FlightDetailResponse> buildUseCaseObservable(GetFLightDetailReq param) {
        if (param == null) {
            return Single.error(new NullPointerException("LoginModel request null"));
        }
        return flightRepository.getFlightDetail(param);
    }
}
