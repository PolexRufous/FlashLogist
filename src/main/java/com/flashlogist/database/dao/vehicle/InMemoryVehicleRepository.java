package com.flashlogist.database.dao.vehicle;

import com.flashlogist.database.entities.vehicle.Vehicle;
import com.flashlogist.database.entities.vehicle.VehicleType;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository("vehicleRepository")
public class InMemoryVehicleRepository implements VehicleRepository {
    private Map<Long, Vehicle> vehicles;

    public InMemoryVehicleRepository() {
        vehicles = new HashMap<>();
        vehicles.put(1L, createVehicle(1L, VehicleType.SHIP));
        vehicles.put(2L, createVehicle(2L, VehicleType.SHIP));
        vehicles.put(3L, createVehicle(3L, VehicleType.TRUCK));
        vehicles.put(4L, createVehicle(4L, VehicleType.TRUCK));
        vehicles.put(5L, createVehicle(5L, VehicleType.TRUCK));
        vehicles.put(6L, createVehicle(6L, VehicleType.CAR));

    }

    private Vehicle createVehicle(long id, VehicleType type) {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(id);
        vehicle.setName("Super vehicle" + type + id);
        vehicle.setManufacturingDate(LocalDate.of(1999, 10, 12));
        return vehicle;
    }

    @Override
    public Collection<Vehicle> getAll() {
        return vehicles.values();
    }

    @Override
    public Vehicle getById(Long id) {
        return vehicles.get(id);
    }
}
