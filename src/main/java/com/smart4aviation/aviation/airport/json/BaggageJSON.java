package com.smart4aviation.aviation.airport.json;

import lombok.Value;

@Value
public class BaggageJSON {
    int id;
    int weight;
    String weightUnit;
    int pieces;
}
