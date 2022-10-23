package com.hititcs.pegasusdcs.remote.service;

import com.hititcs.pegasusdcs.data.remote.FlightRemote;
import com.hititcs.pegasusdcs.domain.model.FlightDetailResponse;
import com.hititcs.pegasusdcs.domain.model.GetFLightDetailReq;
import com.hititcs.pegasusdcs.domain.model.GetFlightsReq;
import com.hititcs.pegasusdcs.domain.model.GetFlightsResponse;
import com.hititcs.pegasusdcs.remote.api.FlightApi;
import com.hititcs.pegasusdcs.remote.mapper.MemberMapper;

import javax.inject.Inject;

import io.reactivex.Single;

public class FlightRemoteImpl implements FlightRemote {

    private final MemberMapper memberMapper;
    private final FlightApi flightApi;

    @Inject
    public FlightRemoteImpl(MemberMapper memberMapper,
                            FlightApi flightApi) {
        this.memberMapper = memberMapper;
        this.flightApi = flightApi;
    }

    @Override
    public Single<GetFlightsResponse> getFlightList(GetFlightsReq req) {
        return flightApi.getFlightList(req);
    }

    @Override
    public Single<FlightDetailResponse> getFlightDetail(GetFLightDetailReq req) {
        return flightApi.getFlightDetail(req);
    }
}
