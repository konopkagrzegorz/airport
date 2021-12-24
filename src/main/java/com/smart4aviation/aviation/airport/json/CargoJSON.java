package com.smart4aviation.aviation.airport.json;

import lombok.Value;

@Value
public class CargoJSON {
    int id;
    double weight;
    long pieces;
    String weightUnit;
}
