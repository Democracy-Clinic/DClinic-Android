package com.dclinic.patient.mapper;

/**
 * Created by HeinHtetZaw on 2/24/21.
 */
public abstract class BiMapper<FromType, ToType> {
    public abstract ToType map(FromType item);

    public abstract FromType reverseMap(ToType item);
}
