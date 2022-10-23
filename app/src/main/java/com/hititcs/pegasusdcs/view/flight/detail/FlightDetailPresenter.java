package com.hititcs.pegasusdcs.view.flight.detail;

import com.hititcs.pegasusdcs.view.LoadPresenter;

public interface FlightDetailPresenter extends LoadPresenter<FlightDetailView> {
    void getFlightDetail(String flightId);
}
