package com.hititcs.pegasusdcs.di.module;

import com.hititcs.pegasusdcs.data.repository.BoardRepositoryImpl;
import com.hititcs.pegasusdcs.data.repository.FlightDataRepository;
import com.hititcs.pegasusdcs.data.repository.LoginDataRepository;
import com.hititcs.pegasusdcs.domain.repository.BoardRepository;
import com.hititcs.pegasusdcs.domain.repository.FlightRepository;
import com.hititcs.pegasusdcs.domain.repository.LoginRepository;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class DataModule {

  @Binds
  public abstract LoginRepository loginRepository(LoginDataRepository loginDataRepository);

  @Binds
  public abstract FlightRepository flightRepository(FlightDataRepository flightDataRepository);

  @Binds
  public abstract BoardRepository boardingRepository(BoardRepositoryImpl boardingDataRepository);

//  @Binds
//  public abstract AirlineRepository airlineRepository(AirlineDataRepository airlineDataRepository);

}
