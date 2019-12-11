package com.sreeyainfotech.mvvmwithlogin.repositiry;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.sreeyainfotech.mvvmwithlogin.Utilities;
import com.sreeyainfotech.mvvmwithlogin.model.LoadDetails;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoadDetailRepository {


   List<LoadDetails> loadDetailsArrayList=new ArrayList<LoadDetails>();



    public LiveData<List<LoadDetails>> getMutubleLiveDataLoadDetails(String driverId, String token) {

        final MutableLiveData<List<LoadDetails>> loadDetailsMutableLiveData = new MutableLiveData<>();

        Call<List<LoadDetails>> call_loadDetals = Utilities.getApiInterface().assaignedLoadsByDriver(driverId,token);
        call_loadDetals.enqueue(new Callback<List<LoadDetails>>() {
            @Override
            public void onResponse(Call<List<LoadDetails>> call, Response<List<LoadDetails>> response) {
                if(response.isSuccessful()){
                    loadDetailsArrayList=response.body();
                    loadDetailsMutableLiveData.setValue(loadDetailsArrayList);
                }else {
                    //clear the list
                    loadDetailsArrayList=response.body();
                    loadDetailsMutableLiveData.setValue(loadDetailsArrayList);
                }
            }

            @Override
            public void onFailure(Call<List<LoadDetails>> call, Throwable t) {

            }
        });


        return loadDetailsMutableLiveData;
    }


}
