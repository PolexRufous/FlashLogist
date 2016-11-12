package com.flashlogist.vehicle.dao.repository;

import com.flashlogist.vehicle.dao.Vehicle;

import java.util.Collection;

public interface VehicleRepository {
    Collection<Vehicle> getAll();
    Vehicle getById(Long id);
}
