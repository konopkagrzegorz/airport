package com.smart4aviation.aviation.airport.json;

import lombok.Value;

@Value
public class FlightEntityJSON {
    int flightId;
    int flightNumber;
    String departureAirportIATACode;
    String arrivalAirportIATACode;
    String departureDate;
}
