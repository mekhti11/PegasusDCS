package com.hititcs.pegasusdcs.view.home.view

import com.hititcs.pegasusdcs.view.LoadPresenter
import com.hititcs.pegasusdcs.view.LoadView

interface HomeContract {
  interface HomePresenter : LoadPresenter<HomeView> {

  }

  interface HomeView : LoadView {

  }
}