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
}
