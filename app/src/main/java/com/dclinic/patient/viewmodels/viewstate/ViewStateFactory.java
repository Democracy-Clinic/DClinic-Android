package com.dclinic.patient.viewmodels.viewstate;

public class ViewStateFactory {
    public static ViewState getError (String message) {
        return new Error(message);
    }

    public static ViewState getLoading () {
        return new Loading();
    }

    public static <T>ViewState getSuccess(T data ) {
        return new Success<T>(data);
    }
}

