package com.hititcs.pegasusdcs.view.flight;

import com.hititcs.pegasusdcs.domain.executer.PostExecutionThread;
import com.hititcs.pegasusdcs.domain.executer.ThreadExecutor;
import com.hititcs.pegasusdcs.domain.interactor.flight.FlightListUseCase;
import com.hititcs.pegasusdcs.domain.repository.FlightRepository;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class FlightListFragmentModule {

  @Provides
  static FlightListUseCase provideFlightListUseCase(FlightRepository flightRepository,
                                                    PostExecutionThread postExecutionThread,
                                                    ThreadExecutor threadExecutor) {
    return new FlightListUseCase(postExecutionThread, threadExecutor, flightRepository);
  }

  @Provides
  static FlightListPresenter provideFlightListPresenter(FlightListView flightListView, FlightListUseCase flightListUseCase) {
    return new FlightListPresenterImpl(flightListView, flightListUseCase);
  }

  @Binds
  abstract FlightListView bindFlightListView(FlightListFragment flightListFragment);

}
