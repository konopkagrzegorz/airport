package com.smart4aviation.aviation.airport.domain;

import lombok.Builder;
import lombok.ToString;

import java.util.List;
import java.util.Objects;

@Builder
@ToString
public class CargoEntity {

    private final int flightId;
    private final List<Baggage> baggage;
    private final List<Cargo> cargo;

    public CargoEntity(int flightId, List<Baggage> baggage, List<Cargo> cargo) {
        this.flightId = flightId;
        this.baggage = baggage;
        this.cargo = cargo;
    }

    public int getFlightId() {
        return flightId;
    }

    public List<Baggage> getBaggage() {
        return baggage;
    }

    public List<Cargo> getCargo() {
        return cargo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CargoEntity that = (CargoEntity) o;

        if (flightId != that.flightId) return false;
        if (!Objects.equals(baggage, that.baggage)) return false;
        return Objects.equals(cargo, that.cargo);
    }

    @Override
    public int hashCode() {
        int result = flightId;
        result = 31 * result + (baggage != null ? baggage.hashCode() : 0);
        result = 31 * result + (cargo != null ? cargo.hashCode() : 0);
        return result;
    }
}
