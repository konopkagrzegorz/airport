package com.smart4aviation.aviation.airport.domain;

public enum WeightUnit {
    KG("kg"),
    LB("lb");

    private final String unit;

    WeightUnit(String unit) {
        this.unit = unit;
    }
}
