package com.smart4aviation.aviation.airport.mapper;

import com.smart4aviation.aviation.airport.domain.FlightEntity;
import com.smart4aviation.aviation.airport.domain.IATA;
import com.smart4aviation.aviation.airport.json.FlightEntityJSON;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

@Component
public class FlightEntityMapper {

    private static final String PATTERN = "yyyy-MM-dd'T'HH:mm:ssZ";

    public FlightEntity flightEntityJSONtoFlightMapper(FlightEntityJSON flight) {
        return FlightEntity.builder()
                .flightId(flight.getFlightId())
                .flightNumber(flight.getFlightNumber())
                .departureAirportIATACode(new IATA(flight.getDepartureAirportIATACode()))
                .arrivalAirportIATACode(new IATA(flight.getArrivalAirportIATACode()))
                .departureDate(dateTime(flight.getDepartureDate())).build();
    }

    private DateTime dateTime(String dateText) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern(PATTERN);
        return formatter.parseDateTime(dateText);
    }
}
