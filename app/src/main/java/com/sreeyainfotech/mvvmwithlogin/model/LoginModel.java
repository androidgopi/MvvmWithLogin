package com.sreeyainfotech.mvvmwithlogin.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginModel {

    @NonNull
    @SerializedName("FullName")
    @Expose
    private String FullName;

    @NonNull
    @SerializedName("Token")
    @Expose
    private String Token;

    @NonNull
    @SerializedName("DriverId")
    @Expose
    private String DriverId;

    @NonNull
    @SerializedName("UserName")
    @Expose
    private String UserName;

    @NonNull
    @SerializedName("Password")
    @Expose
    private String Password;

    @NonNull
    @SerializedName("FirstName")
    @Expose
    private String FirstName;

    @NonNull
    @SerializedName("LastName")
    @Expose
    private String LastName;

    @NonNull
    @SerializedName("EmailAddress")
    @Expose
    private String EmailAddress;

    @NonNull
    @SerializedName("MobileNumber")
    @Expose
    private String MobileNumber;

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public String getDriverId() {
        return DriverId;
    }

    public void setDriverId(String driverId) {
        DriverId = driverId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
    }

    public String getMobileNumber() {
        return MobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        MobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
