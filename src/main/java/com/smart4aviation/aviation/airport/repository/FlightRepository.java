package com.smart4aviation.aviation.airport.repository;

import com.smart4aviation.aviation.airport.domain.Flight;
import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Predicate;

@Repository
public class FlightRepository {

    private final List<Flight> flights = new ArrayList<>();

    public void addFlight(Flight flight) {
        this.flights.add(flight);
    }

    public List<Flight> findAll() {
        return flights;
    }

    public Flight findFlightByFlightNumberAndDate(int flightId, DateTime date) {
        Optional<Flight> flight = flights.stream().filter(getFlight(flightId,date)).findFirst();
        if (flight.isEmpty())
            throw new NoSuchElementException(String.format("Flight with flight id: %d",flightId));
        return flight.get();
    }

    private Predicate<Flight> getFlight(int flightNumber, DateTime date) {
        return flight -> flight.getFlightNumber() == flightNumber && flight.getDepartureDate().equals(date);
    }
}
