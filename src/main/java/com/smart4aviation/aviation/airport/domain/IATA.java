package com.smart4aviation.aviation.airport.domain;

import org.springframework.context.annotation.Bean;

public class IATA {

    private final String code;

    public IATA(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IATA iata = (IATA) o;

        return code.equals(iata.code);
    }

    @Override
    public int hashCode() {
        return code.hashCode();
    }

    @Override
    public String toString() {
        return code;
    }
}
