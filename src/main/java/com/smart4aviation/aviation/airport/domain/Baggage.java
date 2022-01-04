package com.smart4aviation.aviation.airport.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Baggage {
    int id;
    double weight;
    long pieces;
    WeightUnit weightUnit;
}
