package com.dclinic.patient.viewmodels.viewstate;

public class Error extends ViewState {

    String message;

    Error(String m) {
        this.message = m;
    }

    public String getMessage() {
        return message;
    }
    
}
