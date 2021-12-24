package com.smart4aviation.aviation.airport.repository;

import com.smart4aviation.aviation.airport.domain.Flight;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FlightRepository {

    private final List<Flight> flights = new ArrayList<>();

    public void addFlight(Flight flight) {
        this.flights.add(flight);
    }

    public List<Flight> findAll() {
        return flights;
    }
}
