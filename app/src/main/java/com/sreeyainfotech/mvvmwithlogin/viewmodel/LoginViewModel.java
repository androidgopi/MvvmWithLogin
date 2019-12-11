package com.sreeyainfotech.mvvmwithlogin.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.sreeyainfotech.mvvmwithlogin.model.LoginModel;
import com.sreeyainfotech.mvvmwithlogin.repositiry.LoginRepositiry;

public class LoginViewModel extends ViewModel {

    LiveData<LoginModel> loginModelLiveData;
    LoginRepositiry loginRepositiry=new LoginRepositiry();

    public LiveData<LoginModel> getLoginModelLiveValueData( String username, String password){
     //  if(loginModelLiveData== null) {
           loginModelLiveData=loginRepositiry.getLoginModelLiveData(username,password);

     //  }
       return loginModelLiveData;
    }
}
