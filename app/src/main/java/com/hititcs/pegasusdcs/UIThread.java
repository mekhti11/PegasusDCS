package com.hititcs.pegasusdcs;

import com.hititcs.pegasusdcs.domain.executer.PostExecutionThread;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;

@Singleton
public class UIThread implements PostExecutionThread {

  @Inject
  public UIThread() {
  }

  @Override
  public Scheduler getScheduler() {
    return AndroidSchedulers.mainThread();
  }
}
