package com.flashlogist.dom.vehicle;

import com.flashlogist.repo.vehicle.VehicleRepository;
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
