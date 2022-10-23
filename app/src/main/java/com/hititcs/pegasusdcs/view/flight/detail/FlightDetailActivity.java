package com.hititcs.pegasusdcs.view.flight.detail;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.hititcs.pegasusdcs.R;
import com.hititcs.pegasusdcs.domain.model.DepartingFlight;
import com.hititcs.pegasusdcs.domain.model.FlightDetailResponse;
import com.hititcs.pegasusdcs.domain.model.FlightSummary;
import com.hititcs.pegasusdcs.util.ParcelUtils;
import com.hititcs.pegasusdcs.view.BaseActivity;

public class FlightDetailActivity extends BaseActivity<FlightDetailActivity> {

  public static final String FLIGHT_SUMMARY = "FLIGHT_SUMMARY." + FlightDetailActivity.class.getSimpleName();
  public static final String ARRIVAL_INDEX = "ARRIVAL_INDEX." + FlightDetailActivity.class.getSimpleName();
  public static final String STATE_FLIGHT = "STATE_FLIGHT." + FlightDetailActivity.class.getSimpleName();

  DepartingFlight flightSummary;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    bindView();
    if (savedInstanceState != null) {
      flightSummary = ParcelUtils.unwrap(savedInstanceState, STATE_FLIGHT);
    } else {
      flightSummary = ParcelUtils.unwrap(getIntent(), FLIGHT_SUMMARY);
      setUpFragment();
    }
    setToolbar();
    setTitle(getString(R.string.page_title_flight_details));
  }

  private void setUpFragment() {
    getSupportFragmentManager()
        .beginTransaction()
        .replace(R.id.content_frame,
            FlightDetailFragment.newInstance(flightSummary),
            FlightDetailFragment.class.getSimpleName())
        .commit();
  }

  @Override
  protected FlightDetailActivity getActivity() {
    return this;
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    outState.putParcelable(STATE_FLIGHT, ParcelUtils.wrap(flightSummary));
    super.onSaveInstanceState(outState);
  }
}
