package com.hititcs.pegasusdcs.view.flight;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.hititcs.pegasusdcs.R;
import com.hititcs.pegasusdcs.util.FragmentUtils;
import com.hititcs.pegasusdcs.view.BaseActivity;

public class FlightListActivity extends BaseActivity<FlightListActivity> {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_content);
    bindView();
    setToolbar();
    setTitle(getString(R.string.page_title_flights));
    if (savedInstanceState == null) {
      setUpFragment();
    }
  }

  private void setUpFragment() {
    FragmentUtils.replaceFragment(getSupportFragmentManager(),
        FlightListFragment.newInstance(), FlightListFragment.class.getSimpleName());
  }

  @Override
  protected FlightListActivity getActivity() {
    return this;
  }
}
