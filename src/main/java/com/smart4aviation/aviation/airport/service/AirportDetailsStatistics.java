package com.smart4aviation.aviation.airport.service;

import com.smart4aviation.aviation.airport.domain.Baggage;
import com.smart4aviation.aviation.airport.domain.Flight;
import com.smart4aviation.aviation.airport.domain.IATA;
import com.smart4aviation.aviation.airport.repository.FlightRepository;
import com.smart4aviation.aviation.airport.repository.LuggageRepository;
import com.smart4aviation.aviation.airport.response.AirportDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportDetailsStatistics {

    private final FlightRepository flightRepository;
    private final LuggageRepository luggageRepository;

    @Autowired
    public AirportDetailsStatistics(FlightRepository flightRepository, LuggageRepository luggageRepository) {
        this.flightRepository = flightRepository;
        this.luggageRepository = luggageRepository;
    }

    public AirportDetails getStatisticsByIATACode(String iataCode) {
        IATA iata = new IATA(iataCode);
        List<Flight> departures = flightRepository.getDeparturesByIATAcode(iata);
        List<Flight> arrivals = flightRepository.getArrivalsByIATAcode(iata);
        long piecesOfBaggageDeparting = getBaggagePiecesCount(departures);
        long piecesOfBaggageArriving = getBaggagePiecesCount(arrivals);
        return AirportDetails
                .builder()
                .departuresNumber(departures.size())
                .arrivalsNumber(arrivals.size())
                .piecesOfBaggageDeparting(piecesOfBaggageDeparting)
                .piecesOfBaggageArriving(piecesOfBaggageArriving)
                .build();
    }

    private long getBaggagePiecesCount(List<Flight> flights) {
        return flights.stream()
                .map(flight -> getBaggageByFlightId(flight.getFlightId()))
                .flatMap(List::stream).mapToLong(Baggage::getPieces).sum();
    }

    private List<Baggage> getBaggageByFlightId(int id) {
        return luggageRepository.findBaggageByFlightId(id);
    }
}
