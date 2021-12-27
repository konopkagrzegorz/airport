package com.smart4aviation.aviation.airport.mapper;

import com.smart4aviation.aviation.airport.domain.Baggage;
import com.smart4aviation.aviation.airport.domain.Cargo;
import com.smart4aviation.aviation.airport.domain.CargoFlight;
import com.smart4aviation.aviation.airport.domain.WeightUnit;
import com.smart4aviation.aviation.airport.json.BaggageJSON;
import com.smart4aviation.aviation.airport.json.CargoEntityJSON;
import com.smart4aviation.aviation.airport.json.CargoJSON;
import com.smart4aviation.aviation.airport.response.CargoWeight;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CargoEntityMapper {

    public CargoFlight cargoEntityJSONtoCargoFlightMapper(CargoEntityJSON cargoEntityJSON) {
        return CargoFlight.builder()
                .flightId(cargoEntityJSON.getFlightId())
                .baggage(baggageJSONListToBaggageListMapper(cargoEntityJSON.getBaggage()))
                .cargo(cargoJSONListToCargoListMapper(cargoEntityJSON.getCargo()))
                .build();
    }

    private List<Baggage> baggageJSONListToBaggageListMapper(List<BaggageJSON> baggageJSONList) {
        return baggageJSONList.stream().map(this::baggageJSONtoBaggageMapper).collect(Collectors.toList());
    }

    private List<Cargo> cargoJSONListToCargoListMapper(List<CargoJSON> cargoJSONList) {
        return cargoJSONList.stream().map(this::cargoJSONtoCargoMapper).collect(Collectors.toList());
    }

    private Baggage baggageJSONtoBaggageMapper(BaggageJSON baggageJSON) {
        return Baggage
                .builder()
                .id(baggageJSON.getId())
                .pieces(baggageJSON.getPieces())
                .weight(baggageJSON.getWeight())
                .weightUnit(WeightUnit.valueOf(baggageJSON.getWeightUnit()))
                .build();
    }

    private Cargo cargoJSONtoCargoMapper(CargoJSON cargoJSON) {
        return Cargo
                .builder()
                .id(cargoJSON.getId())
                .pieces(cargoJSON.getPieces())
                .weight(cargoJSON.getWeight())
                .weightUnit(WeightUnit.valueOf(cargoJSON.getWeightUnit()))
                .build();
    }
}
