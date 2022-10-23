package com.hititcs.pegasusdcs.view.flight;


import com.hititcs.pegasusdcs.view.LoadPresenter;

import org.threeten.bp.LocalDate;

public interface FlightListPresenter extends LoadPresenter<FlightListView> {

  void getFlightList(LocalDate selectedDate);
}
