package com.dclinic.patient.viewmodels.viewstate;

public class Success<T> extends ViewState {
    T uiData;

    Success(T data) {
        this.uiData = data;
    }

    public T getUiData() {
        return uiData;
    }
}
