package com.hititcs.pegasusdcs.data.repository;

import com.hititcs.pegasusdcs.data.remote.FlightRemote;
import com.hititcs.pegasusdcs.domain.model.FlightDetailResponse;
import com.hititcs.pegasusdcs.domain.model.GetFLightDetailReq;
import com.hititcs.pegasusdcs.domain.model.GetFlightsReq;
import com.hititcs.pegasusdcs.domain.model.GetFlightsResponse;
import com.hititcs.pegasusdcs.domain.repository.FlightRepository;

import javax.inject.Inject;

import io.reactivex.Single;

public class FlightDataRepository implements FlightRepository {

    private FlightRemote flightRemote;

    @Inject
    public FlightDataRepository(FlightRemote flightRemote) {
        this.flightRemote = flightRemote;
    }

    @Override
    public Single<FlightDetailResponse> getFlightDetail(GetFLightDetailReq req) {
        return flightRemote.getFlightDetail(req);
    }

    @Override
    public Single<GetFlightsResponse> getFlights(GetFlightsReq flightListRequest) {
        return flightRemote.getFlightList(flightListRequest);
    }
}