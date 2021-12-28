package com.smart4aviation.aviation.airport.controller;

import com.smart4aviation.aviation.airport.domain.Flight;
import com.smart4aviation.aviation.airport.repository.FlightRepository;
import com.smart4aviation.aviation.airport.response.AirportDetails;
import com.smart4aviation.aviation.airport.service.AirportDetailsStatistics;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FlightController {

    private final AirportDetailsStatistics airportDetailsStatistics;

    @Autowired
    public FlightController(AirportDetailsStatistics airportDetailsStatistics) {
        this.airportDetailsStatistics = airportDetailsStatistics;
    }


    @GetMapping("/airport")
    public ResponseEntity<AirportDetails> getAirportDetails(@RequestParam String iataCode) {
        return ResponseEntity.ok(airportDetailsStatistics.getStatisticsByIATACode(iataCode));
    }
}
