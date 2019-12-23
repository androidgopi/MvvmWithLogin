package com.sreeyainfotech.mvvmwithlogin.viewmodel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.sreeyainfotech.mvvmwithlogin.Utilities;
import com.sreeyainfotech.mvvmwithlogin.model.LoadDetails;
import com.sreeyainfotech.mvvmwithlogin.repositiry.LoadDetailRepository;

import java.util.List;

public class LoadDetailViewModel extends ViewModel {
    public static LoadDetailViewModel instances;

    LiveData<List<LoadDetails>> loadDetailsLiveData;
    LoadDetailRepository loadDetailRepository;


    public static LoadDetailViewModel getInstance() {
        if (instances == null) {

            instances = new LoadDetailViewModel();
        }
        return instances;
    }


    public LiveData<List<LoadDetails>> getLoadDetailsLiveData(Context context) {

        loadDetailRepository= LoadDetailRepository.getInstance();

        String driverId = Utilities.getPref(context, "driverId", "");
        String token = "Bearer"+" "+Utilities.getPref(context, "token", "");
        try {
            loadDetailsLiveData = loadDetailRepository.getMutubleLiveDataLoadDetails(driverId, token);
        } catch (NullPointerException e) {

        }

        return loadDetailsLiveData;
    }
}
