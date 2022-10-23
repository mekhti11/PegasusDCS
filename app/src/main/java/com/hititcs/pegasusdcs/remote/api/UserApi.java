package com.hititcs.pegasusdcs.remote.api;

import com.hititcs.pegasusdcs.domain.model.LoginRequest;
import com.hititcs.pegasusdcs.domain.model.LoginResponse;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserApi {

    @POST("login/get-token")
    Single<LoginResponse> loginRx(@Body LoginRequest request);

}
