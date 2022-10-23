package com.hititcs.pegasusdcs.view.home.view

import android.os.Bundle
import com.hititcs.pegasusdcs.R
import com.hititcs.pegasusdcs.view.BaseActivity

class HomeActivity : BaseActivity<HomeActivity>() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_content)
    bindView()
    setUpFragment()
  }

  private fun setUpFragment() {
    supportFragmentManager
      .beginTransaction()
      .replace(
        R.id.content_frame,
        HomeFragment.newInstance(),
        HomeFragment::class.java.simpleName
      )
      .commit()
  }

  override fun getActivity(): HomeActivity {
    return this
  }
}