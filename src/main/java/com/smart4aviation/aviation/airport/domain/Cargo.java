package com.smart4aviation.aviation.airport.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Cargo {

    int id;
    double weight;
    long pieces;
    WeightUnit weightUnit;
}
