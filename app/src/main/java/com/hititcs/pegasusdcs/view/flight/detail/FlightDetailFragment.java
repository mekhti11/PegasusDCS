package com.hititcs.pegasusdcs.view.flight.detail;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.hititcs.pegasusdcs.R;
import com.hititcs.pegasusdcs.model.DeviceEnum;
import com.hititcs.pegasusdcs.util.AnimUtils;
import com.hititcs.pegasusdcs.domain.model.DepartingFlight;
import com.hititcs.pegasusdcs.domain.model.DeviceUtils;
import com.hititcs.pegasusdcs.domain.model.FlightDetailResponse;
import com.hititcs.pegasusdcs.util.DateTimeUtils;
import com.hititcs.pegasusdcs.util.ParcelUtils;
import com.hititcs.pegasusdcs.view.BaseFragment;
import com.hititcs.pegasusdcs.view.Presenter;
import com.hititcs.pegasusdcs.view.barcode.ScanBarcodeActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class FlightDetailFragment extends BaseFragment<FlightDetailFragment> implements
    FlightDetailView {

  public static final String FLIGHT_ID = "FLIGHT_ID";
  public static final String BOARDED_COUNT_START = "BOARDED_COUNT_START";
  public static final String EXTRA_FLIGHT = "extra:flight";
  @Inject
  FlightDetailPresenter flightDetailPresenter;

  @BindView(R.id.scan_barcode)
  LinearLayout scanBarcodeButton;

  @BindView(R.id.tv_dep_port)
  TextView tvDepPort;
  @BindView(R.id.tv_arr_port)
  TextView tvArrPort;
  @BindView(R.id.tv_flight_type)
  TextView tvFlightType;
  @BindView(R.id.tv_dep_date)
  TextView tvDepDate;
  @BindView(R.id.tv_arr_date)
  TextView tvArrDate;
  @BindView(R.id.tv_boarding_time)
  TextView tvBoardingTime;
  @BindView(R.id.tv_gate)
  TextView tvGate;
  @BindView(R.id.tv_flight_no)
  TextView tvFlightNo;
  @BindView(R.id.tv_aircraft)
  TextView tvAircraft;
  @BindView(R.id.tv_reg)
  TextView tvReg;
  @BindView(R.id.tv_gate_detail)
  TextView tvGateDetail;
  @BindView(R.id.tv_check_in)
  TextView tvCheckIn;
  @BindView(R.id.tv_unboarded)
  TextView tvUnboarded;
  @BindView(R.id.tv_boarded)
  TextView tvBoarded;
  @BindView(R.id.tv_boarding_gate)
  TextView tvBoardingGate;
  @BindView(R.id.tv_delay_time)
  TextView tvDelayTime;
  @BindView(R.id.rlt_flight_detail)
  RelativeLayout rltFlightDetail;
  @BindView(R.id.tv_flight_status)
  TextView tvTopFlightStatus;
  @BindView(R.id.tv_flight_status_data)
  TextView tvFlightStatus;
  private String boardedCount;
  private DepartingFlight flightSummary;
  private Drawable companyLogo;

  public static FlightDetailFragment newInstance(DepartingFlight flightSummary) {
    Bundle args = new Bundle();
    ParcelUtils.wrap(args, EXTRA_FLIGHT, flightSummary);
    FlightDetailFragment fragment = new FlightDetailFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    flightSummary = ParcelUtils.unwrap(getArguments(), EXTRA_FLIGHT);
  }

  @Override
  protected FlightDetailFragment getFragment() {
    return this;
  }

  @Override
  protected Presenter getPresenter() {
    return flightDetailPresenter;
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    final View fragmentView = inflater.inflate(R.layout.content_flight_detail, container, false);
    bindView(fragmentView);
    return fragmentView;
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
  }

  public void hideBoarding() {
    rltFlightDetail.setVisibility(View.GONE);
  }

  @Override
  public void onResume() {
    super.onResume();
    flightDetailPresenter.setView(this);
    flightDetailPresenter.getFlightDetail(flightSummary.getLegIsn());
  }

  @Override
  public void onPause() {
    flightDetailPresenter.destroyView();
    super.onPause();
  }

  @Override
  public void showFlightDetail(FlightDetailResponse flightsOutputDto) {
    tvDepPort.setText(flightsOutputDto.getMobileDcsFlight().getDeparture().getLocation().getPortCode());
    tvArrPort.setText(flightsOutputDto.getMobileDcsFlight().getArrivalList().get(0).getLocation().getPortCode());
    tvFlightNo.setText(String.format("%s%s", flightSummary.getAaCode(),
        flightSummary.getFlightNo()));
    tvFlightType.setText(flightsOutputDto.getMobileDcsFlight().getAaCode());
    tvGate.setText(flightsOutputDto.getMobileDcsFlight().getBoardingGate());
    tvBoardingTime.setText(String.format("%s: %s", getString(R.string.item_flight_boarding_time),
        DateTimeUtils
            .getTimeFromZonedDateTime(flightsOutputDto.getMobileDcsFlight().getBoardingTime())));
    tvDepDate.setText(
        DateTimeUtils.getTimeFromZonedDateTime(flightsOutputDto.getMobileDcsFlight().getDeparture().getLocalTime()));
    tvArrDate.setText(
        DateTimeUtils.getTimeFromZonedDateTime(flightsOutputDto.getMobileDcsFlight().getArrivalList().get(0).getLocalTime()));

    tvReg.setText(flightsOutputDto.getMobileDcsFlight().getEquipmentType().getAcReg());
    tvAircraft.setText(flightsOutputDto.getMobileDcsFlight().getEquipmentType().getAirEquipTypeModel());

    tvGateDetail.setText(flightsOutputDto.getMobileDcsFlight().getBoardingGate());
    if (flightsOutputDto.getMobileDcsFlight().getDeparture().getSegmentFigure()!=null &&
            !String.valueOf(flightsOutputDto.getMobileDcsFlight().getDeparture().getSegmentFigure().getTotalBoardedPassenger()).isEmpty()) {
      tvBoarded.setText(String.valueOf(flightsOutputDto.getMobileDcsFlight().getDeparture().getSegmentFigure().getTotalBoardedPassenger()));
      boardedCount = String.valueOf(flightsOutputDto.getMobileDcsFlight().getDeparture().getSegmentFigure().getTotalBoardedPassenger());
    } else {
      tvBoarded.setText("0");
      boardedCount = "0";
    }
    if (flightsOutputDto.getMobileDcsFlight().getDeparture().getSegmentFigure()!=null &&
            !String.valueOf(flightsOutputDto.getMobileDcsFlight().getDeparture().getSegmentFigure().getTotalCheckedPassenger()).isEmpty()) {
      tvCheckIn.setText(String.valueOf(flightsOutputDto.getMobileDcsFlight().getDeparture().getSegmentFigure().getTotalCheckedPassenger()));
    } else {
      tvCheckIn.setText("0");
    }
    if (flightsOutputDto.getMobileDcsFlight().getDeparture().getSegmentFigure()!=null &&
            !String.valueOf(flightsOutputDto.getMobileDcsFlight().getDeparture().getSegmentFigure().getTotalUnboardedPassenger()).isEmpty()) {
      tvUnboarded.setText(String.valueOf(flightsOutputDto.getMobileDcsFlight().getDeparture().getSegmentFigure().getTotalUnboardedPassenger()));
    } else {
      tvUnboarded.setText("0");
    }
//
    tvBoardingGate.setText(flightsOutputDto.getMobileDcsFlight().getBoardingGate());
    tvDelayTime.setText(
        DateTimeUtils.normalizeZonedDateTime(flightsOutputDto.getMobileDcsFlight().getDelayTime()));
    tvTopFlightStatus.setText(String.format("%s: %s", getString(R.string.item_flight_flight_status),
        flightsOutputDto.getMobileDcsFlight().getStatus()));
    tvFlightStatus.setText(flightsOutputDto.getMobileDcsFlight().getStatus());

    if(tvFlightStatus.getText().toString().equals("CI") || tvFlightStatus.getText().toString().equals("CC")){
      scanBarcodeButton.setVisibility(View.VISIBLE);
    }
    else{
      scanBarcodeButton.setVisibility(View.GONE);
    }


    rltFlightDetail.setVisibility(View.VISIBLE);
    AnimUtils.animateShowView(rltFlightDetail);
  }

  @Override
  public void showLoading() {
    hideBoarding();
    super.showLoading();
  }

  @Override
  public void hideLoading() {
    super.hideLoading();
  }

  @Override
  public void showError(String message) {

  }

  @Override
  public void showError(int messageId) {

  }

  private void openScanBarcodeZebra() {
    Intent intent = new Intent(getActivity(), ScanBarcodeActivity.class);
    intent.putExtra(FLIGHT_ID, flightSummary.getLegIsn());
    intent.putExtra(BOARDED_COUNT_START, boardedCount);
    intent.putExtra(ScanBarcodeActivity.SELECTED_DEVICE, DeviceEnum.ZEBRA.getValue());
    startActivity(intent);
  }

  private void openScanBarcodeKranger() {
    Intent intent = new Intent(getActivity(), ScanBarcodeActivity.class);
    intent.putExtra(FLIGHT_ID, flightSummary.getLegIsn());
    intent.putExtra(BOARDED_COUNT_START, boardedCount);
    intent.putExtra(ScanBarcodeActivity.SELECTED_DEVICE, DeviceEnum.K_RANGER.getValue());
    startActivity(intent);
  }

  private void openScanBarcodeCamera() {
    Intent intent = new Intent(getActivity(), ScanBarcodeActivity.class);
    intent.putExtra(FLIGHT_ID, flightSummary.getLegIsn());
    intent.putExtra(BOARDED_COUNT_START, boardedCount);
    intent.putExtra(ScanBarcodeActivity.SELECTED_DEVICE, DeviceEnum.CAMERA.getValue());
    startActivity(intent);
  }

  private void showCameraAndZebraDeviceSelectionDialog() {
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    builder.setTitle(R.string.dialog_title_select_a_device)
        .setItems(R.array.barcode_devices_array_zebra, (dialog, selectedPosition) -> {
          if (selectedPosition == 0) {
            openScanBarcodeZebra();
          } else if (selectedPosition == 1) {
            openScanBarcodeCamera();
          }
        });
    builder.create();
    builder.show();
  }

  private void showCameraAndKrangerDeviceSelectionDialog() {
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    builder.setTitle(R.string.dialog_title_select_a_device)
        .setItems(R.array.barcode_devices_array_kranger, (dialog, selectedPosition) -> {
          if (selectedPosition == 0) {
            openScanBarcodeKranger();
          } else if (selectedPosition == 1) {
            openScanBarcodeCamera();
          }
        });
    builder.create();
    builder.show();
  }

  private void showCameraAndPrangerDeviceSelectionDialog() {
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    builder.setTitle(R.string.dialog_title_select_a_device)
        .setItems(R.array.barcode_devices_array_pranger, (dialog, selectedPosition) -> {
          if (selectedPosition == 0) {
            openScanBarcodeKranger();
          } else if (selectedPosition == 1) {
            openScanBarcodeCamera();
          }
        });
    builder.create();
    builder.show();
  }

  @OnClick(R.id.scan_barcode)
  public void onScanBarcodeClicked() {
    if (DeviceUtils.isManufacturerZebra()) {
      showCameraAndZebraDeviceSelectionDialog();
    } else if (DeviceUtils.isModelKrangerRow()) {
      showCameraAndKrangerDeviceSelectionDialog();
    } else if (DeviceUtils.isModelRangerPro()) {
      showCameraAndPrangerDeviceSelectionDialog();
    } else {
      openScanBarcodeCamera();
    }
  }
}
