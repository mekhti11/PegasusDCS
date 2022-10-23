package com.hititcs.pegasusdcs.domain.interactor.flight;

import com.hititcs.pegasusdcs.domain.executer.PostExecutionThread;
import com.hititcs.pegasusdcs.domain.executer.ThreadExecutor;
import com.hititcs.pegasusdcs.domain.interactor.SingleWithParamUseCase;
import com.hititcs.pegasusdcs.domain.model.GetFlightsReq;
import com.hititcs.pegasusdcs.domain.model.GetFlightsResponse;
import com.hititcs.pegasusdcs.domain.repository.FlightRepository;

import javax.inject.Inject;

import io.reactivex.Single;

public class FlightListUseCase extends SingleWithParamUseCase<GetFlightsResponse, GetFlightsReq> {


    FlightRepository flightRepository;

    @Inject
    public FlightListUseCase(PostExecutionThread postExecutionThread,
                             ThreadExecutor threadExecutor,
                             FlightRepository flightRepository) {
        super(postExecutionThread, threadExecutor);
        this.flightRepository = flightRepository;
    }

    @Override
    protected Single<GetFlightsResponse> buildUseCaseObservable(GetFlightsReq param) {
        if (param == null) {
            return Single.error(new NullPointerException("LoginModel request null"));
        }
        return flightRepository.getFlights(param);
    }
}
