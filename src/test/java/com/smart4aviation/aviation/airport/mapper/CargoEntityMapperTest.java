package com.smart4aviation.aviation.airport.mapper;

import com.smart4aviation.aviation.airport.domain.Baggage;
import com.smart4aviation.aviation.airport.domain.Cargo;
import com.smart4aviation.aviation.airport.domain.CargoEntity;
import com.smart4aviation.aviation.airport.domain.WeightUnit;
import com.smart4aviation.aviation.airport.json.BaggageJSON;
import com.smart4aviation.aviation.airport.json.CargoEntityJSON;
import com.smart4aviation.aviation.airport.json.CargoJSON;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CargoEntityMapperTest {

    private CargoEntityMapper cargoEntityMapper;

    @BeforeEach
    void setUp() {
        cargoEntityMapper = new CargoEntityMapper();
    }

    @Test
    void cargoEntityJSONtoCargoFlightMapper() {
        List<BaggageJSON> baggageJSONList = new ArrayList<>();
        baggageJSONList.add(new BaggageJSON(0,100,"kg",50));
        baggageJSONList.add(new BaggageJSON(1,150,"kg",150));
        baggageJSONList.add(new BaggageJSON(2,170,"kg",250));

        List<CargoJSON> cargoJSONList = new ArrayList<>();
        cargoJSONList.add(new CargoJSON(0,100,40,"lb"));
        cargoJSONList.add(new CargoJSON(1,200,40,"lb"));

        CargoEntityJSON cargoEntityJSON = new CargoEntityJSON(0,baggageJSONList,cargoJSONList);

        List<Baggage> baggage = new ArrayList<>();
        baggage.add(new Baggage(0,100,50, WeightUnit.kg));
        baggage.add(new Baggage(1,150,150,WeightUnit.kg));
        baggage.add(new Baggage(2,170,250,WeightUnit.kg));

        List<Cargo> cargo = new ArrayList<>();
        cargo.add(new Cargo(0,100,40, WeightUnit.lb));
        cargo.add(new Cargo(1,200,40,WeightUnit.lb));

        CargoEntity expected = new CargoEntity(0,baggage,cargo);

        CargoEntity actual = cargoEntityMapper.cargoEntityJSONtoCargoFlightMapper(cargoEntityJSON);

        assertEquals(expected,actual);
    }
}
