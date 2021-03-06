package com.dclinic.patient.data.error;

public class NegativeResult<Error> extends ResultEvent<Error>{

    private Error error ;

    public NegativeResult(Error error) {
        this.error = error;
    }

    @Override
    public Error getData() {
        return error;
    }
}
