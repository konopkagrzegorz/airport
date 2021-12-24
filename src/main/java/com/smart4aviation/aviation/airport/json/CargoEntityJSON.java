package com.smart4aviation.aviation.airport.json;

import lombok.Value;

import java.util.List;

@Value
public class CargoEntityJSON {
    int flightId;
    List<BaggageJSON> baggage;
    List<CargoJSON> cargo;
}
