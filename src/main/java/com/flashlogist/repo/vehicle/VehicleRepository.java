package com.flashlogist.repo.vehicle;

import com.flashlogist.dom.vehicle.Vehicle;

import java.util.Collection;

public interface VehicleRepository {
    Collection<Vehicle> getAll();
    Vehicle getById(Long id);
}
