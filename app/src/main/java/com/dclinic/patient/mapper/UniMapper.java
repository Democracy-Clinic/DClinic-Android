package com.dclinic.patient.mapper;

abstract class UniMapper<F , T> {
    abstract T map (F item);
}