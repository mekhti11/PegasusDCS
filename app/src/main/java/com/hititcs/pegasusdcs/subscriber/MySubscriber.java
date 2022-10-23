package com.hititcs.pegasusdcs.subscriber;

public interface MySubscriber<T> {

  void onResponse(T data);

}