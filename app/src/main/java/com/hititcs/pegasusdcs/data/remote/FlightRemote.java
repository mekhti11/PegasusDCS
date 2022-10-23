package com.hititcs.pegasusdcs.data.remote;

import com.hititcs.pegasusdcs.domain.model.FlightDetailResponse;
import com.hititcs.pegasusdcs.domain.model.GetFLightDetailReq;
import com.hititcs.pegasusdcs.domain.model.GetFlightsReq;
import com.hititcs.pegasusdcs.domain.model.GetFlightsResponse;

import io.reactivex.Single;

public interface FlightRemote {

    Single<GetFlightsResponse> getFlightList(GetFlightsReq req);

    Single<FlightDetailResponse> getFlightDetail(GetFLightDetailReq req);
}
