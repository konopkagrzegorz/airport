package com.smart4aviation.aviation.airport.mapper;

import com.smart4aviation.aviation.airport.domain.FlightEntity;
import com.smart4aviation.aviation.airport.domain.IATA;
import com.smart4aviation.aviation.airport.json.FlightEntityJSON;
import org.joda.time.DateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlightEntityMapperTest {

    private FlightEntityMapper flightEntityMapper;

    @BeforeEach
    void setUp() {
        flightEntityMapper = new FlightEntityMapper();
    }

    @Test
    void flightEntityJSONtoFlightMapper() {
        FlightEntityJSON flightEntityJSON = new FlightEntityJSON(
                0,
                4229,
                "LAX",
                "MIT",
                "2017-08-28T07:57:33-02:00");

        FlightEntity expected = new FlightEntity(
                0,
                4229,new IATA("LAX"),
                new IATA("MIT"),
                new DateTime("2017-08-28T09:57:33.000Z"));

        FlightEntity actual = flightEntityMapper.flightEntityJSONtoFlightMapper(flightEntityJSON);
        assertEquals(expected,actual);
    }
}