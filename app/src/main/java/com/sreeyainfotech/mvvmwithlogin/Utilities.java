package com.sreeyainfotech.mvvmwithlogin;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;

import com.sreeyainfotech.mvvmwithlogin.networkcall.ApiInterface;
import com.sreeyainfotech.mvvmwithlogin.networkcall.ApiServices;


public class Utilities {

    private static ProgressDialog mProgressDialog;
   private static ApiInterface apiInterface;


    public static void savebooleanPref(Context context, String key, boolean value) {
        SharedPreferences sharedPref = context.getSharedPreferences("Login_Preferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public static ApiInterface getApiInterface(){
       return apiInterface = ApiServices.getClient().create(ApiInterface.class);
    }

    public static boolean getBooleanPref(Context context, String key, boolean defaultValue) {
        SharedPreferences sharedPref = context.getSharedPreferences("Login_Preferences", Context.MODE_PRIVATE);
        return sharedPref.getBoolean(key, defaultValue);
    }

    public static void savePref(Context context, String key, String value) {
        SharedPreferences sharedPref = context.getSharedPreferences("MobileApp_Preferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static String getPref(Context context, String key, String defaultValue) {
        SharedPreferences sharedPref = context.getSharedPreferences("MobileApp_Preferences", Context.MODE_PRIVATE);
        return sharedPref.getString(key, defaultValue);
    }


    public static void showLoading(Context context, String message) {
        mProgressDialog = new ProgressDialog(context);
        mProgressDialog.setMessage(message);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressDialog.setCancelable(true);
        mProgressDialog.show();
    }

    public static void hideLoading() {
        if (mProgressDialog != null || mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }





}
