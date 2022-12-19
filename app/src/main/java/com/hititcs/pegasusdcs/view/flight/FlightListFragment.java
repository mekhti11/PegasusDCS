package com.hititcs.pegasusdcs.view.flight;

import static com.hititcs.pegasusdcs.view.flight.detail.FlightDetailActivity.ARRIVAL_INDEX;
import static com.hititcs.pegasusdcs.view.flight.detail.FlightDetailActivity.FLIGHT_SUMMARY;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hititcs.pegasusdcs.R;
import com.hititcs.pegasusdcs.domain.model.Arrival;
import com.hititcs.pegasusdcs.util.AnimUtils;
import com.hititcs.pegasusdcs.domain.model.DepartingFlight;
import com.hititcs.pegasusdcs.util.AppUtils;
import com.hititcs.pegasusdcs.util.DateTimeUtils;
import com.hititcs.pegasusdcs.util.ImageUtils;
import com.hititcs.pegasusdcs.util.ParcelUtils;
import com.hititcs.pegasusdcs.view.BaseFragment;
import com.hititcs.pegasusdcs.view.Presenter;
import com.hititcs.pegasusdcs.view.flight.detail.FlightDetailActivity;

import org.threeten.bp.LocalDate;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class FlightListFragment extends BaseFragment<FlightListFragment> implements FlightListView,
        FlightListAdapter.FlightOnClickListener {

  @BindView(R.id.rcw_flights)
  RecyclerView recyclerViewFlights;
  @BindView(R.id.tw_current_date)
  TextView twDate;
  @BindView(R.id.tw_prev_date)
  TextView twDateBack;
  @BindView(R.id.tw_next_date)
  TextView twDateForward;
  @BindView(R.id.tw_total_number_of_flights)
  TextView twTotalNumberOfFlights;
  @BindView(R.id.tw_current_date_today)
  TextView twTodayLabel;
  @BindView(R.id.edt_search)
  TextView edtSearch;

  @Inject
  FlightListPresenter flightListPresenter;

  private FlightListAdapter flightListAdapter;
  private LocalDate selectedDate = LocalDate.now();
  private List<DepartingFlight> flightList = new ArrayList<>();

  public static FlightListFragment newInstance() {
    Bundle args = new Bundle();
    FlightListFragment fragment = new FlightListFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  protected FlightListFragment getFragment() {
    return this;
  }

  @Override
  protected Presenter getPresenter() {
    return flightListPresenter;
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setHasOptionsMenu(true);
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                           @Nullable Bundle savedInstanceState) {
    final View fragmentView = inflater.inflate(R.layout.content_flight_list, container, false);
    bindView(fragmentView);
    return fragmentView;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    edtSearch.addTextChangedListener(new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence s, int start, int count, int after) {

      }

      @Override
      public void onTextChanged(CharSequence s, int start, int before, int count) {

      }

      @Override
      public void afterTextChanged(Editable s) {
        showFlightList(flightList);
      }
    });
  }


  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    selectedDate = LocalDate.now();
    twDateBack.setText(DateTimeUtils.formatDateEnglishName(selectedDate.minusDays(1)));
    twDate.setText(DateTimeUtils.formatDateEnglishName(selectedDate));
    twTodayLabel.setVisibility(View.VISIBLE);
    twDateForward.setText(DateTimeUtils.formatDateEnglishName(selectedDate.plusDays(1)));
  }

  @Override
  public void onSaveInstanceState(@NonNull Bundle outState) {
    super.onSaveInstanceState(outState);
  }

  @Override
  public void onResume() {
    super.onResume();
    flightListPresenter.setView(this);
    if (edtSearch != null) {
      edtSearch.setText("");
    }
    flightListPresenter.getFlightList(selectedDate);
  }

  @Override
  public void onPause() {
    flightListPresenter.destroyView();
    super.onPause();
  }

  @Override
  public void showFlightList(List<DepartingFlight> flightSummaries) {
    initRecyclerView();
    if (flightSummaries.size()>0) {
      flightList = flightSummaries;
      flightList =  parseList();
       flightListAdapter.update(filterFlightsByFlightNumber(edtSearch.getText().toString()));
      recyclerViewFlights.scrollToPosition(0);
      recyclerViewFlights.setVisibility(View.VISIBLE);
      twTotalNumberOfFlights.setText(String
              .format("%d %s", flightListAdapter.getItemCount(), getString(R.string.home_flights_found)));
      twTotalNumberOfFlights.setVisibility(View.VISIBLE);
      AnimUtils.animateShowView(recyclerViewFlights);
    }
  }

  private ArrayList<DepartingFlight> parseList() {
    ArrayList<DepartingFlight> temp = new ArrayList<>();
    temp.addAll(flightList);
    for (int i = 0; i <flightList.size() ; i++) {
      for (int j = i + 1; j < flightList.size(); j++) {
        if (flightList.get(i).getLegIsn().equals(flightList.get(j).getLegIsn())) {
          if (flightList.get(i).getArrivalList().size() > 0 && flightList.get(j).getArrivalList().size() > 0 &&
                  flightList.get(i).getArrivalList().size() < flightList.get(j).getArrivalList().size()) {
            temp.remove(i);
          }
        }
      }
    }

    ArrayList<DepartingFlight> listForAdapter = new ArrayList<>();

    for (DepartingFlight dp : temp){

      for (Arrival arr : dp.getArrivalList()){
        DepartingFlight tmp = new DepartingFlight();

        tmp.setAaCode(dp.getAaCode());
        tmp.setFlightNo(dp.getFlightNo());
        tmp.setBoardingGate(dp.getBoardingGate());
        tmp.setBoardingTime(dp.getBoardingTime());
        tmp.setStatus(dp.getStatus());
        tmp.setDelayTime(dp.getDelayTime());
        tmp.setLegIsn(dp.getLegIsn());
        tmp.setDeparture(dp.getDeparture());
        tmp.setArrivalList(new ArrayList<>());
        tmp.getArrivalList().add(arr);

        listForAdapter.add(tmp);
      }
    }
    return listForAdapter;
  }

  private List<DepartingFlight> filterFlightsByFlightNumber(String number) {
    number = number.trim();
    if (number.equals("")) {
      return flightList;
    }
    List<DepartingFlight> filteredList = new ArrayList<>();
    for (int i = 0; i < flightList.size(); i++) {
      if (flightList.get(i).getFlightNo().startsWith(number)) {
        filteredList.add(flightList.get(i));
      }
    }
    return filteredList;
  }

  public void hideFlightList() {
    twTotalNumberOfFlights.setVisibility(View.INVISIBLE);
    recyclerViewFlights.setVisibility(View.GONE);
  }

  @Override
  public void showLoading() {
    hideFlightList();
    super.showLoading();
  }

  @Override
  public void hideLoading() {
    super.hideLoading();
  }

  @Override
  public void startFlightDetailActivity(DepartingFlight flightSummary,int position) {
    Intent intent = new Intent(getActivity(), FlightDetailActivity.class);
    intent.putExtra(FLIGHT_SUMMARY, ParcelUtils.wrap(flightSummary));
    intent.putExtra(ARRIVAL_INDEX,position);
    startActivity(intent);
  }

  private void initRecyclerView() {
    flightListAdapter = new FlightListAdapter(this,
            ImageUtils.loadImageUriAsDrawable(getContext(), AppUtils.getCompanyLogoUri(getContext())));
    recyclerViewFlights.setLayoutManager(new LinearLayoutManager(getContext()));
    recyclerViewFlights.setAdapter(flightListAdapter);
  }

  @OnClick(R.id.ln_prev)
  public void goPreviousDay() {
    selectedDate = selectedDate.minusDays(1);
    flightListPresenter.getFlightList(selectedDate);
    updateView();
  }

  @OnClick(R.id.ln_next)
  public void goNextDay() {
    selectedDate = selectedDate.plusDays(1);
    flightListPresenter.getFlightList(selectedDate);
    updateView();
  }

  public void updateView() {
    twDate.setText(DateTimeUtils.formatDateEnglishName(selectedDate));
    twDateBack.setText(DateTimeUtils.formatDateEnglishName(selectedDate.minusDays(1)));
    twDateForward.setText(DateTimeUtils.formatDateEnglishName(selectedDate.plusDays(1)));
    if (selectedDate.getDayOfYear() == LocalDate.now().getDayOfYear()) {
      twTodayLabel.setVisibility(View.VISIBLE);
    } else {
      twTodayLabel.setVisibility(View.INVISIBLE);
    }
    flightListAdapter.notifyDataSetChanged();
  }

  @Override
  public void showError(String message) {

  }

  @Override
  public void showError(int messageId) {

  }
}