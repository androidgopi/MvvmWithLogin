package com.sreeyainfotech.mvvmwithlogin.repositiry;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.JsonObject;
import com.sreeyainfotech.mvvmwithlogin.Utilities;
import com.sreeyainfotech.mvvmwithlogin.model.LoginModel;
import com.sreeyainfotech.mvvmwithlogin.networkcall.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRepositiry {
    ApiInterface apiInterface;
    LoginModel loginModel;

    public LiveData<LoginModel> getLoginModelLiveData( String userName, String password) {

       // apiInterface = ApiServices.getClient().create(ApiInterface.class);

        final MutableLiveData<LoginModel> loginModelMutableLiveData = new MutableLiveData<>();

        JsonObject object = new JsonObject();
        object.addProperty("UserName", userName);
        object.addProperty("Password", password);

        Call<LoginModel> loginModelCall = Utilities.getApiInterface().doGetResources(object);
        loginModelCall.enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                if (response.isSuccessful()) {
                    loginModel = response.body();
                    loginModelMutableLiveData.setValue(loginModel);
                }else {
                    loginModel = response.body();
                    loginModelMutableLiveData.setValue(loginModel);
                }
            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {

            }
        });

        return loginModelMutableLiveData;
    }
}
