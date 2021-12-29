package com.smart4aviation.aviation.airport.controller;

import com.smart4aviation.aviation.airport.response.AirportDetails;
import com.smart4aviation.aviation.airport.service.AirportDetailsStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AirportDetailsStatisticsController {

    private final AirportDetailsStatistics airportDetailsStatistics;

    @Autowired
    public AirportDetailsStatisticsController(AirportDetailsStatistics airportDetailsStatistics) {
        this.airportDetailsStatistics = airportDetailsStatistics;
    }


    @GetMapping("/airport")
    public ResponseEntity<AirportDetails> getAirportDetails(@RequestParam String iataCode) {
        return ResponseEntity.ok(airportDetailsStatistics.getStatisticsByIATACode(iataCode));
    }
}
