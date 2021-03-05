package com.dclinic.patient.data.vos.map;

/**
 * Created by HeinHtetZaw on 2/17/21.
 */
public class ClinicsMapVO {
    private String clinicID = "";
    private double latitude = 0.0;
    private double longitude = 0.0;
    private String clinicName = "";
    private String address = "";
    private String clinicOpenTime = "";
    private String clinicCloseTime = "";
    private String[] phoneNumbers;

    public String getClinicID() {
        return clinicID;
    }

    public void setClinicID(String clinicID) {
        this.clinicID = clinicID;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getClinicOpenTime() {
        return clinicOpenTime;
    }

    public void setClinicOpenTime(String clinicOpenTime) {
        this.clinicOpenTime = clinicOpenTime;
    }

    public String getClinicCloseTime() {
        return clinicCloseTime;
    }

    public void setClinicCloseTime(String clinicCloseTime) {
        this.clinicCloseTime = clinicCloseTime;
    }

    public String[] getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(String[] phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }


    public  ClinicsMapVO(String clinicID, String clinicName, double latitude, double longitude) {
        this.clinicID = clinicID;
        this.latitude = latitude;
        this.longitude = longitude;
        this.clinicName = clinicName;

    }

    public ClinicsMapVO(String clinicID, double latitude, double longitude, String clinicName, String address, String clinicOpenTime, String clinicCloseTime, String[] phoneNumbers) {
        this.clinicID = clinicID;
        this.latitude = latitude;
        this.longitude = longitude;
        this.clinicName = clinicName;
        this.address = address;
        this.clinicOpenTime = clinicOpenTime;
        this.clinicCloseTime = clinicCloseTime;
        this.phoneNumbers = phoneNumbers;
    }
}
