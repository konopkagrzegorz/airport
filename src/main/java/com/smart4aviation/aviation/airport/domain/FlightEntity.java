package com.smart4aviation.aviation.airport.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.joda.deser.LocalDateDeserializer;
import lombok.Builder;
import org.joda.time.DateTime;


@Builder
public class FlightEntity {

    private final int flightId;
    private final int flightNumber;
    private final IATA departureAirportIATACode;
    private final IATA arrivalAirportIATACode;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private final DateTime departureDate;

    public FlightEntity(int flightId, int flightNumber, IATA departureAirportIATACode, IATA arrivalAirportIATACode, DateTime departureDate) {
        this.flightId = flightId;
        this.flightNumber = flightNumber;
        this.departureAirportIATACode = departureAirportIATACode;
        this.arrivalAirportIATACode = arrivalAirportIATACode;
        this.departureDate = departureDate;
    }

    public int getFlightId() {
        return flightId;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public IATA getDepartureAirportIATACode() {
        return departureAirportIATACode;
    }

    public IATA getArrivalAirportIATACode() {
        return arrivalAirportIATACode;
    }

    public DateTime getDepartureDate() {
        return departureDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FlightEntity flight = (FlightEntity) o;

        if (flightId != flight.flightId) return false;
        if (flightNumber != flight.flightNumber) return false;
        if (!departureAirportIATACode.equals(flight.departureAirportIATACode)) return false;
        if (!arrivalAirportIATACode.equals(flight.arrivalAirportIATACode)) return false;
        return departureDate.equals(flight.departureDate);
    }

    @Override
    public int hashCode() {
        int result = flightId;
        result = 31 * result + flightNumber;
        result = 31 * result + departureAirportIATACode.hashCode();
        result = 31 * result + arrivalAirportIATACode.hashCode();
        result = 31 * result + departureDate.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightId=" + flightId +
                ", flightNumber=" + flightNumber +
                ", departureAirportIATACode=" + departureAirportIATACode +
                ", arrivalAirportIATACode=" + arrivalAirportIATACode +
                ", departureDate=" + departureDate +
                '}';
    }
}
