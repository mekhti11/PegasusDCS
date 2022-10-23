package com.hititcs.pegasusdcs.remote.api;

import com.hititcs.pegasusdcs.domain.model.FlightDetailResponse;
import com.hititcs.pegasusdcs.domain.model.GetFLightDetailReq;
import com.hititcs.pegasusdcs.domain.model.GetFlightsReq;
import com.hititcs.pegasusdcs.domain.model.GetFlightsResponse;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface FlightApi {

    @POST("flight/search-flightlist")
    Single<GetFlightsResponse> getFlightList(@Body GetFlightsReq req);

    @POST("flight/flight-detail")
    Single<FlightDetailResponse> getFlightDetail(@Body GetFLightDetailReq req);
}
