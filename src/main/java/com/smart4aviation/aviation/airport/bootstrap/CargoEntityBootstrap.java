package com.smart4aviation.aviation.airport.bootstrap;

import com.google.gson.reflect.TypeToken;
import com.smart4aviation.aviation.airport.json.CargoEntityJSON;
import com.smart4aviation.aviation.airport.json.JSONReader;
import com.smart4aviation.aviation.airport.mapper.CargoEntityMapper;
import com.smart4aviation.aviation.airport.repository.CargoEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Component
public class CargoEntityBootstrap implements CommandLineRunner {

    private static final String CARGO_JSON_PATH = "/cargo_entity.json";

    private final CargoEntityRepository luggageRepository;
    private final CargoEntityMapper cargoEntityMapper;

    @Autowired
    public CargoEntityBootstrap(CargoEntityRepository luggageRepository, CargoEntityMapper cargoEntityMapper) {
        this.luggageRepository = luggageRepository;
        this.cargoEntityMapper = cargoEntityMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        JSONReader jsonReader = new JSONReader();
        Type type = new TypeToken<ArrayList<CargoEntityJSON>>() {}.getType();
        List<CargoEntityJSON> cargoFlights = jsonReader.read(CARGO_JSON_PATH,type);

        cargoFlights.stream()
                .map(cargoEntityMapper::cargoEntityJSONtoCargoFlightMapper)
                .forEach(luggageRepository::addCargoData);
    }
}
