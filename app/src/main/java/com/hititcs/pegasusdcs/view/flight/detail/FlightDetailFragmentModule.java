package com.hititcs.pegasusdcs.view.flight.detail;

import com.hititcs.pegasusdcs.domain.executer.PostExecutionThread;
import com.hititcs.pegasusdcs.domain.executer.ThreadExecutor;
import com.hititcs.pegasusdcs.domain.interactor.flight.FlightDetailUseCase;
import com.hititcs.pegasusdcs.domain.repository.FlightRepository;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class FlightDetailFragmentModule {

    @Provides
    static FlightDetailUseCase provideFlightDetailUseCase(FlightRepository flightRepository,
                                                          PostExecutionThread postExecutionThread,
                                                          ThreadExecutor threadExecutor) {
        return new FlightDetailUseCase(postExecutionThread, threadExecutor, flightRepository);
    }

    @Provides
    static FlightDetailPresenter provideFlightDetailPresenter(FlightDetailView flightDetailView, FlightDetailUseCase flightDetailUseCase) {
        return new FlightDetailPresenterImpl(flightDetailView, flightDetailUseCase);
    }

    @Binds
    abstract FlightDetailView bindFlightDetailView(FlightDetailFragment flightDetailFragment);

}
