package com.smart4aviation.aviation.airport.controller;

import com.smart4aviation.aviation.airport.domain.Flight;
import com.smart4aviation.aviation.airport.repository.FlightRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
}
