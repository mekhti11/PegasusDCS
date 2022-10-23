package com.hititcs.pegasusdcs.domain.repository;

import com.hititcs.pegasusdcs.domain.model.FlightDetailResponse;
import com.hititcs.pegasusdcs.domain.model.GetFLightDetailReq;
import com.hititcs.pegasusdcs.domain.model.GetFlightsReq;
import com.hititcs.pegasusdcs.domain.model.GetFlightsResponse;

import io.reactivex.Single;

public interface FlightRepository {

    Single<FlightDetailResponse> getFlightDetail(GetFLightDetailReq req);

    Single<GetFlightsResponse> getFlights(GetFlightsReq flightListRequest);

}