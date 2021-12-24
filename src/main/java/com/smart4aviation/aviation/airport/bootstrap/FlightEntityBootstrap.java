package com.smart4aviation.aviation.airport.bootstrap;
import com.google.gson.reflect.TypeToken;
import com.smart4aviation.aviation.airport.json.FlightEntityJSON;
import com.smart4aviation.aviation.airport.json.JSONReader;
import com.smart4aviation.aviation.airport.mapper.FlightEntityMapper;
import com.smart4aviation.aviation.airport.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Component
public class FlightEntityBootstrap implements CommandLineRunner {

    private static final String FLIGHT_JSON_PATH = "/flight_entity.json";

    private final FlightRepository flightRepository;
    private final FlightEntityMapper flightEntityMapper;

    @Autowired
    public FlightEntityBootstrap(FlightRepository flightRepository, FlightEntityMapper flightEntityMapper) {
        this.flightRepository = flightRepository;
        this.flightEntityMapper = flightEntityMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        JSONReader jsonReader = new JSONReader();
        Type type = new TypeToken<ArrayList<FlightEntityJSON>>() {}.getType();
        List<FlightEntityJSON> flights = jsonReader.read(FLIGHT_JSON_PATH,type);

        flights.stream()
                .map(flightEntityMapper::flightEntityJSONtoFlightMapper)
                .forEach(flightRepository::addFlight);
    }
}
