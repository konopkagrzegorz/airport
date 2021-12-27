package com.smart4aviation.aviation.airport.service;

import com.smart4aviation.aviation.airport.domain.Flight;
import com.smart4aviation.aviation.airport.repository.FlightRepository;
import com.smart4aviation.aviation.airport.response.CargoWeight;
import com.smart4aviation.aviation.airport.response.FlightDetailData;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
// TODO: 27.12.2021  
public class DetailFlightStatistic {

    private final FlightRepository flightRepository;

    @Autowired
    public DetailFlightStatistic(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }


    public FlightDetailData getDetailsAboutFlight(int flightNumber, String date) {
        String pattern = "yyyy-MM-dd'T'HH:mm:ssZ";
        DateTimeFormatter formatter = DateTimeFormat.forPattern(pattern);
        Flight flight = flightRepository.findFlightByFlightNumberAndDate(flightNumber,formatter.parseDateTime(date));
        if (Objects.nonNull(flight)) {
            CargoWeight cargoWeight = CargoWeight
                    .builder()
                    .kg(flight.)
                    .lb()
                    .build();
            DetailFlightStatistic flightStatistic = FlightDetailData
                    .builder()
                    .baggageWeight()
                    .cargoWeight()
                    .totalWeight()
                    .build();
        }
    }
}
