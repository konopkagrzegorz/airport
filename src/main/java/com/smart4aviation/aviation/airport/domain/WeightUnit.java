package com.smart4aviation.aviation.airport.domain;

public enum WeightUnit {
    kg("kg"),
    lb("lb");

    private final String unit;

    WeightUnit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }
}
