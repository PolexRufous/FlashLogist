package com.flashlogist.dom.vehicle;

import lombok.Data;

import java.time.LocalDate;

public @Data
class Vehicle {
    private Long id;
    private String name;
    private VehicleType type;
    private LocalDate manufacturingDate;
}
