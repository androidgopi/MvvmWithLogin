package com.sreeyainfotech.mvvmwithlogin.networkcall;

import com.google.gson.JsonObject;
import com.sreeyainfotech.mvvmwithlogin.model.LoadDetails;
import com.sreeyainfotech.mvvmwithlogin.model.LoginModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {

    @POST("account/token")
    Call<LoginModel> doGetResources(@Body JsonObject object);

    @GET("drivers/{driverId}/loads")
    Call<List<LoadDetails>> assaignedLoadsByDriver(@Path("driverId") String driverId,
                                                   @Header("Authorization") String auth);

}
