package com.hititcs.pegasusdcs.view.flight;


import com.hititcs.pegasusdcs.domain.model.DepartingFlight;
import com.hititcs.pegasusdcs.view.LoadView;

import java.util.List;

public interface FlightListView extends LoadView {
  void showFlightList(List<DepartingFlight> flightSummaries);
}
