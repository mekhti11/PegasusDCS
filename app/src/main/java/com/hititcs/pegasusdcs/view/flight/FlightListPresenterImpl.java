package com.hititcs.pegasusdcs.view.flight;

import com.hititcs.pegasusdcs.di.scope.FlightListScope;
import com.hititcs.pegasusdcs.domain.interactor.flight.FlightListUseCase;
import com.hititcs.pegasusdcs.domain.model.GetFlightsReq;
import com.hititcs.pegasusdcs.domain.model.GetFlightsResponse;
import com.hititcs.pegasusdcs.subscriber.SingleSubscriber;
import com.hititcs.pegasusdcs.util.DateTimeUtils;

import org.threeten.bp.LocalDate;

import javax.inject.Inject;

@FlightListScope
public class FlightListPresenterImpl implements FlightListPresenter {

    private FlightListView flightListView;
    private final FlightListUseCase flightListUseCase;

    @Inject
    public FlightListPresenterImpl(FlightListView flightListView, FlightListUseCase flightListUseCase) {
        this.flightListView = flightListView;
        this.flightListUseCase = flightListUseCase;
    }

    @Override
    public void getFlightList(LocalDate selectedDate) {
        GetFlightsReq flightListRequest = new GetFlightsReq();
        flightListRequest.setDepPort("SAW");
        flightListRequest.setSchDeptDate(DateTimeUtils.formatDateToRequestFormat(selectedDate));

//        flightListRequest.setEndDate(DateTimeUtils.formatDateToRequestFormat(selectedDate));

        showViewLoading();
        flightListUseCase.execute(new SingleSubscriber<GetFlightsResponse>(this) {
            @Override
            public void onResponse(GetFlightsResponse data) {
                hideViewLoading();
                getView().showFlightList(data.getDepartingFlightList());
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
            }
        }, flightListRequest);

    }

    @Override
    public FlightListView getView() {
        return flightListView;
    }

    @Override
    public void setView(FlightListView view) {
        this.flightListView = view;
    }

    @Override
    public void dispose() {
        if (flightListUseCase != null) {
            flightListUseCase.dispose();
        }
    }
}
