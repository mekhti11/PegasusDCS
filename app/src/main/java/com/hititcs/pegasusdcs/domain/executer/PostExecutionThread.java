package com.hititcs.pegasusdcs.domain.executer;

import io.reactivex.Scheduler;

public interface PostExecutionThread {

  Scheduler getScheduler();
}