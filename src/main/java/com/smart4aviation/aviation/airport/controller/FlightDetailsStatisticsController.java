package com.smart4aviation.aviation.airport.controller;

import com.smart4aviation.aviation.airport.response.FlightDetailData;
import com.smart4aviation.aviation.airport.service.FlightDetailsStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FlightDetailsStatisticsController {

    private final FlightDetailsStatistics flightStatistic;

    @Autowired
    public FlightDetailsStatisticsController(FlightDetailsStatistics flightStatistic) {
        this.flightStatistic = flightStatistic;
    }

    @GetMapping(value = "/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FlightDetailData> statistics(@RequestParam int flightNumber, @RequestParam String date) {
        return ResponseEntity.ok(flightStatistic.getDetailsAboutFlight(flightNumber,date).get());
    }
}
