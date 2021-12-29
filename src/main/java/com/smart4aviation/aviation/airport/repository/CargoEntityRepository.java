package com.smart4aviation.aviation.airport.repository;

import com.smart4aviation.aviation.airport.domain.Baggage;
import com.smart4aviation.aviation.airport.domain.Cargo;
import com.smart4aviation.aviation.airport.domain.CargoEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CargoEntityRepository {

    private final List<CargoEntity> cargoFlights = new ArrayList<>();

    public void addCargoData(CargoEntity cargoEntity) {
        this.cargoFlights.add(cargoEntity);
    }

    public List<CargoEntity> getAll() {
        return this.cargoFlights;
    }

    public CargoEntity findCargoFlight(int flightId) {
        return cargoFlights.stream().filter(cargoFlight -> cargoFlight.getFlightId() == flightId)
                .findFirst()
                .orElseThrow(() -> new NullPointerException(String.format("Entity with flight id: %d not found", flightId)));
    }

    public List<Baggage> findBaggageByFlightId(int flightId) {
        return findCargoFlight(flightId).getBaggage();
    }

    public List<Cargo> findCargoByFlightId(int flightId) {
        return findCargoFlight(flightId).getCargo();
    }
}
