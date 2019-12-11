package com.sreeyainfotech.mvvmwithlogin.model;

import java.io.Serializable;

public class LoadDetails implements Serializable {
    String LoadId;
    String LoadTrackingNumber;
    String Stops;
    String Status;

    public String getLoadId() {
        return LoadId;
    }

    public void setLoadId(String loadId) {
        LoadId = loadId;
    }

    public String getLoadTrackingNumber() {
        return LoadTrackingNumber;
    }

    public void setLoadTrackingNumber(String loadTrackingNumber) {
        LoadTrackingNumber = loadTrackingNumber;
    }

    public String getStops() {
        return Stops;
    }

    public void setStops(String stops) {
        Stops = stops;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
