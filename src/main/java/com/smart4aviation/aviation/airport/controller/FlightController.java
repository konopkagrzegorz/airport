package com.smart4aviation.aviation.airport.controller;

import com.smart4aviation.aviation.airport.domain.Flight;
import com.smart4aviation.aviation.airport.repository.FlightRepository;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FlightController {

    private final FlightRepository flightRepository;

    public FlightController(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @GetMapping("flights/all")
    public ResponseEntity<List<Flight>> getAllFlight() {
        return ResponseEntity.ok(flightRepository.findAll());
    }

    @GetMapping("flights")
    public ResponseEntity<Flight> getFlightDetails(@RequestParam int flightNumber, @RequestParam String date) {
        String pattern = "yyyy-MM-dd'T'HH:mm:ssZ";
        DateTimeFormatter formatter = DateTimeFormat.forPattern(pattern);
        return ResponseEntity.ok(flightRepository.findFlightByFlightNumberAndDate(flightNumber, formatter.parseDateTime(date)));
    }
}
