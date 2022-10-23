package com.hititcs.pegasusdcs.view.flight.detail;

import com.hititcs.pegasusdcs.domain.model.FlightDetailResponse;
import com.hititcs.pegasusdcs.view.LoadView;

public interface FlightDetailView extends LoadView {
    void showFlightDetail(FlightDetailResponse flightsOutputDto);
}
