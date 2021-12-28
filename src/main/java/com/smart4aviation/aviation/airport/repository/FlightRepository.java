package com.smart4aviation.aviation.airport.repository;

import com.smart4aviation.aviation.airport.domain.Flight;
import com.smart4aviation.aviation.airport.domain.IATA;
import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

    public List<Flight> getDeparturesByIATAcode(IATA iata) {
        List<Flight> departures = new ArrayList<>();
        flights.stream()
                .filter(flight -> flight.getDepartureAirportIATACode().equals(iata)).
                forEach(departures::add);
        return departures;
    }

    public List<Flight> getArrivalsByIATAcode(IATA iata) {
        List<Flight> arrivals = new ArrayList<>();
        flights.stream()
                .filter(flight -> flight.getArrivalAirportIATACode().equals(iata)).
                forEach(arrivals::add);
        return arrivals;
    }
}
