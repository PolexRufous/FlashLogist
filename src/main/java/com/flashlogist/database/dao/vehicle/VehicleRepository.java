package com.flashlogist.database.dao.vehicle;

import com.flashlogist.database.entities.vehicle.Vehicle;

import java.util.Collection;

public interface VehicleRepository {
    Collection<Vehicle> getAll();
    Vehicle getById(Long id);
}
