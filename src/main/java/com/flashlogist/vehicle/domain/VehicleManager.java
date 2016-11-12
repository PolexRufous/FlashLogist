package com.flashlogist.vehicle.domain;

import com.flashlogist.vehicle.dao.repository.VehicleRepository;
import com.flashlogist.vehicle.dao.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class VehicleManager {
    @Autowired
    private VehicleRepository vehicleRepository;

    public Collection<Vehicle> getAll() {
        return vehicleRepository.getAll();
    }

    public Vehicle getById(Long id) {
        return vehicleRepository.getById(id);
    }
}
