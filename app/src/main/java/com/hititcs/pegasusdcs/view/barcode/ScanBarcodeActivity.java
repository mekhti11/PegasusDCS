package com.hititcs.pegasusdcs.view.barcode;

import static com.hititcs.pegasusdcs.view.flight.detail.FlightDetailFragment.BOARDED_COUNT_START;
import static com.hititcs.pegasusdcs.view.flight.detail.FlightDetailFragment.FLIGHT_ID;

import android.os.Bundle;

import androidx.annotation.Nullable;;
import com.hititcs.pegasusdcs.R;
import com.hititcs.pegasusdcs.model.DeviceEnum;
import com.hititcs.pegasusdcs.view.BaseActivity;
import com.hititcs.pegasusdcs.view.barcode.kranger.ScanBarcodeKrangerFragment;
import com.hititcs.pegasusdcs.view.barcode.zebra.ScanBarcodeZebraFragment;
import com.hititcs.pegasusdcs.view.flight.detail.FlightDetailFragment;

public class ScanBarcodeActivity extends BaseActivity<ScanBarcodeActivity> {

  public static final String SELECTED_DEVICE =
      "SELECTED_DEVICE." + FlightDetailFragment.class.getSimpleName();

  String flightId;
  String boardedCountStart;
  String selectedDevice;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_scan_barcode);
    flightId = getIntent().getStringExtra(FLIGHT_ID);
    boardedCountStart = getIntent().getStringExtra(BOARDED_COUNT_START);
    selectedDevice = getIntent().getStringExtra(SELECTED_DEVICE);
    bindView();
    setToolbar();
    hideToolbar();
    if (selectedDevice.equalsIgnoreCase(DeviceEnum.CAMERA.getValue())) {
      setUpCameraFragment();
    } else if (selectedDevice.equalsIgnoreCase(DeviceEnum.ZEBRA.getValue())) {
      setUpZebraFragment();
    } else if (selectedDevice.equalsIgnoreCase(DeviceEnum.K_RANGER.getValue())) {
      setUpKrangerFragment();
    }
  }

  private void setUpCameraFragment() {
    getSupportFragmentManager()
        .beginTransaction()
        .replace(R.id.content_frame,
            ScanBarcodeFragment.newInstance(flightId, boardedCountStart),
            ScanBarcodeFragment.class.getSimpleName())
        .commit();
  }

  private void setUpZebraFragment() {
    getSupportFragmentManager()
        .beginTransaction()
        .replace(R.id.content_frame,
            ScanBarcodeZebraFragment.newInstance(flightId, boardedCountStart),
            ScanBarcodeZebraFragment.class.getSimpleName())
        .commit();
  }

  private void setUpKrangerFragment() {
    getSupportFragmentManager()
        .beginTransaction()
        .replace(R.id.content_frame,
            ScanBarcodeKrangerFragment.newInstance(flightId, boardedCountStart),
            ScanBarcodeKrangerFragment.class.getSimpleName())
        .commit();
  }

  @Override
  protected ScanBarcodeActivity getActivity() {
    return this;
  }
}
