package com.smart4aviation.aviation.airport.repository;

import com.smart4aviation.aviation.airport.domain.FlightEntity;
import com.smart4aviation.aviation.airport.domain.IATA;
import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Predicate;

@Repository
public class FlightEntityRepository {

    private final List<FlightEntity> flights = new ArrayList<>();

    public void addFlight(FlightEntity flightEntity) {
        this.flights.add(flightEntity);
    }

    public List<FlightEntity> findAll() {
        return flights;
    }

    public FlightEntity findFlightByFlightNumberAndDate(int flightId, DateTime date) {
        Optional<FlightEntity> flight = flights.stream().filter(getFlight(flightId,date)).findFirst();
        if (flight.isEmpty())
            throw new NoSuchElementException(String.format("Flight with flight id: %d",flightId));
        return flight.get();
    }

    private Predicate<FlightEntity> getFlight(int flightNumber, DateTime date) {
        return flight -> flight.getFlightNumber() == flightNumber && flight.getDepartureDate().equals(date);
    }

    public List<FlightEntity> getDeparturesByIATAcode(IATA iata) {
        List<FlightEntity> departures = new ArrayList<>();
        flights.stream()
                .filter(flight -> flight.getDepartureAirportIATACode().equals(iata)).
                forEach(departures::add);
        return departures;
    }

    public List<FlightEntity> getArrivalsByIATAcode(IATA iata) {
        List<FlightEntity> arrivals = new ArrayList<>();
        flights.stream()
                .filter(flight -> flight.getArrivalAirportIATACode().equals(iata)).
                forEach(arrivals::add);
        return arrivals;
    }
}
