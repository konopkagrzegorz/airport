package com.smart4aviation.aviation.airport.response;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AirportDetails {
    long departuresNumber;
    long arrivalsNumber;
    long piecesOfBaggageDeparting;
    long piecesOfBaggageArriving;

}
