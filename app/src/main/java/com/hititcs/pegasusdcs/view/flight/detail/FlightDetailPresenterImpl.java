package com.hititcs.pegasusdcs.view.flight.detail;

import com.hititcs.pegasusdcs.di.scope.FlightDetailScope;
import com.hititcs.pegasusdcs.domain.interactor.flight.FlightDetailUseCase;
import com.hititcs.pegasusdcs.domain.model.FlightDetailResponse;
import com.hititcs.pegasusdcs.domain.model.GetFLightDetailReq;
import com.hititcs.pegasusdcs.subscriber.SingleSubscriber;

import javax.inject.Inject;

@FlightDetailScope
public class FlightDetailPresenterImpl implements FlightDetailPresenter {

    private FlightDetailView flightDetailView;
    private final FlightDetailUseCase flightDetailUseCase;

    @Inject
    public FlightDetailPresenterImpl(FlightDetailView flightDetailView, FlightDetailUseCase flightDetailUseCase) {
        this.flightDetailView = flightDetailView;
        this.flightDetailUseCase = flightDetailUseCase;
    }

    @Override
    public FlightDetailView getView() {
        return flightDetailView;
    }

    @Override
    public void setView(FlightDetailView view) {
        this.flightDetailView = view;
    }

    @Override
    public void dispose() {
        if (flightDetailUseCase != null) {
            flightDetailUseCase.dispose();
        }
    }

    @Override
    public void getFlightDetail(String legIsn) {

        showViewLoading();
        GetFLightDetailReq req = new GetFLightDetailReq();
        req.setLegIsn(legIsn);

        flightDetailUseCase.execute(new SingleSubscriber<FlightDetailResponse>(this) {
            @Override
            public void onResponse(FlightDetailResponse data) {
                flightDetailView.showFlightDetail(data);
                flightDetailView.hideLoading();
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
            }
        }, req);
    }
}
