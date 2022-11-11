package com.hititcs.pegasusdcs.subscriber;

import android.text.TextUtils;
import android.util.Log;

import com.hititcs.pegasusdcs.view.LoadPresenter;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Objects;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;
import timber.log.Timber;

public abstract class SingleSubscriber<T> implements SingleObserver<T>, MySubscriber<T> {

  private LoadPresenter presenter;

  protected SingleSubscriber(LoadPresenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void onSuccess(T tData) {
    Log.d("TAG", "onSuccessType: " + tData.getClass().getSimpleName());
    if (tData != null) {
      onResponse(tData);
    } else {
      onError(new Exception("Username or password not valid"));
    }
  }

  @Override
  public void onError(Throwable e) {
    Timber.e(e, e.getMessage());
    Timber.d("TAG", "onError: " + e.getMessage());
    if (presenter == null) {
      return;
    }
    presenter.hideViewLoading();

    if (e instanceof HttpException) {
      switch (((HttpException) e).code()) {
        case 404:
          presenter.show404Error();
          break;
        case 401:
        case 403:
          presenter.showTokenErrorAndNavigateToLogin();
          break;
        default:
          String errorMessage = null;
          if (((HttpException) e).response().errorBody() != null) {
            String errorResponseBody = null;
            try {
              errorResponseBody = Objects.requireNonNull(((HttpException) e).response().errorBody()).string();
            } catch (IOException e1) {
              Timber.e(e1);
            }
            Timber.d("Error response body %s", errorResponseBody);
            try {
              errorMessage = new JSONObject(errorResponseBody).getString("errorCode");
            } catch (JSONException e1) {
              Timber.e(e1);
            }
          } else {
            errorMessage = e.getMessage();
          }
          Timber.d("Error message %s", errorMessage);
          presenter.showError(errorMessage);
      }
    } else if (e instanceof IOException) {
      presenter.noInternetConnection();
    } else {
      presenter.showError(TextUtils.isEmpty(e.getMessage()) ? "Undefined Error" : e.getMessage());
    }
  }

  @Override
  public void onSubscribe(Disposable d) {

  }

  public String getErrorMessage(Throwable e) {
    String errorMessage = null;
    if (((HttpException) e).response().errorBody() != null) {
      String errorResponseBody = null;
      try {
        errorResponseBody = Objects.requireNonNull(((HttpException) e).response().errorBody()).string();
      } catch (IOException e1) {
        Timber.e(e1);
      }
      Timber.d("Error response body %s", errorResponseBody);
      try {
        errorMessage = new JSONObject(errorResponseBody).getString("errorCode");
      } catch (JSONException e1) {
        Timber.e(e1);
      }
    }

    return getError(errorMessage);
  }

  public String getError(String errorMessage){
    String error = null;

    if (errorMessage!=null){
      switch (errorMessage){
        case("ERR_C00"):
        case("ERR_C87"): {
          error = "UNDEFINED ERROR";
          break;
        }
        case("ERR_C50"):{
          error = "INVALID TOKEN";
          break;
        }
        case("ERR_D58"):{
          error = "BOARDING ERROR";
          break;
        }
        case("ERR_D141"):{
          error = "FLIGHT MISMATCH";
          break;
        }
        case("ERR_D142"):{
          error = "ALREADY BOARDED";
          break;
        }
        case("ERR_D146"):{
          error = "BARCODE EMPTY";
          break;
        }
        case("ERR_D147"):{
          error = "BARCODE PARSE ERROR";
          break;
        }
      }
    }

    return error;
  }
}
