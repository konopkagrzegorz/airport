package com.smart4aviation.aviation.airport.service;

import com.smart4aviation.aviation.airport.domain.Baggage;
import com.smart4aviation.aviation.airport.domain.Cargo;
import com.smart4aviation.aviation.airport.domain.CargoFlight;
import com.smart4aviation.aviation.airport.domain.Flight;
import com.smart4aviation.aviation.airport.repository.FlightRepository;
import com.smart4aviation.aviation.airport.repository.LuggageRepository;
import com.smart4aviation.aviation.airport.response.BaggageWeight;
import com.smart4aviation.aviation.airport.response.CargoWeight;
import com.smart4aviation.aviation.airport.response.FlightDetailData;
import com.smart4aviation.aviation.airport.response.TotalWeight;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class FlightDetailsStatistics {

    private final FlightRepository flightRepository;
    private final LuggageRepository luggageRepository;

    @Autowired
    public FlightDetailsStatistics(FlightRepository flightRepository, LuggageRepository luggageRepository) {
        this.flightRepository = flightRepository;
        this.luggageRepository = luggageRepository;
    }

    public Optional<FlightDetailData> getDetailsAboutFlight(int flightNumber, String date) {
        String pattern = "yyyy-MM-dd'T'HH:mm:ssZ";
        DateTimeFormatter formatter = DateTimeFormat.forPattern(pattern);
        Flight flight = flightRepository.findFlightByFlightNumberAndDate(flightNumber,formatter.parseDateTime(date));
        if (Objects.nonNull(flight)) {
            CargoFlight cargoFlight = luggageRepository.findCargoFlight(flight.getFlightId());
            double weightInKG = 0;
            double weightInLB = 0;
            for (Baggage baggage : cargoFlight.getBaggage()) {
                switch (baggage.getWeightUnit()) {
                    case kg:
                        weightInKG += baggage.getWeight();
                        break;
                    case lb:
                        weightInLB += baggage.getWeight();
                        break;
                }
            }
            BaggageWeight baggageWeight = BaggageWeight.builder().kg(weightInKG).lb(weightInLB).build();
            weightInKG = 0;
            weightInLB = 0;
            for (Cargo cargo : cargoFlight.getCargo()) {
                switch (cargo.getWeightUnit()) {
                    case kg:
                        weightInKG += cargo.getWeight();
                        break;
                    case lb:
                        weightInLB += cargo.getWeight();
                        break;
                }
            }
            CargoWeight cargoWeight = CargoWeight.builder().kg(weightInKG).lb(weightInLB).build();
            FlightDetailData flightStatistic = FlightDetailData
                    .builder()
                    .baggageWeight(baggageWeight)
                    .cargoWeight(cargoWeight)
                    .totalWeight(sumWeight(baggageWeight,cargoWeight))
                    .build();
            return Optional.of(flightStatistic);
        }
        return Optional.empty();
    }

    private TotalWeight sumWeight(BaggageWeight baggageWeight, CargoWeight cargoWeight) {
        double weightInKg = 0;
        double weightInLb = 0;
        weightInKg = baggageWeight.getKg() + cargoWeight.getKg();
        weightInLb = baggageWeight.getLb() + cargoWeight.getLb();
        return TotalWeight.builder().kg(weightInKg).lb(weightInLb).build();
    }
}
