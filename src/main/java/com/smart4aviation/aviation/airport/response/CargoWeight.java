package com.smart4aviation.aviation.airport.response;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CargoWeight {

    double kg;
    double lb;

}
