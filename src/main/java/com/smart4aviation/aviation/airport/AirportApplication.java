package com.smart4aviation.aviation.airport;

import com.smart4aviation.aviation.airport.bootstrap.FlightEntityBootstrap;
import com.smart4aviation.aviation.airport.domain.Flight;
import com.smart4aviation.aviation.airport.mapper.FlightEntityMapper;
import com.smart4aviation.aviation.airport.repository.FlightRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AirportApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirportApplication.class, args);
	}

}
