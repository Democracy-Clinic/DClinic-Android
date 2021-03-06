package com.dclinic.patient.data.error;

public class PositiveResult<Data> extends ResultEvent<Data>{

    private Data data ;
    public PositiveResult(Data data ) {
        this.data = data;
    }

    @Override
    public Data getData() {
        return data;
    }
}
