package com.flashlogist.web.restservices;

import com.flashlogist.database.entities.vehicle.Vehicle;
import com.flashlogist.dom.VehicleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Produces;
import java.util.Collection;

@RestController
@RequestMapping("/rest/vehicle")
public class VehicleService {
    @Autowired
    VehicleManager vehicleManager;

    @GetMapping
    @ResponseBody
    @Produces(value = "application/json")
    public ResponseEntity getAll() {
        Collection<Vehicle> vehicles = vehicleManager.getAll();
        if(vehicles.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(201).body(vehicles);
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    @Produces(value = "application/json")
    public ResponseEntity getById(@PathVariable("id") Long id) {
        Vehicle vehicle = vehicleManager.getById(id);
        if (vehicle == null) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(201).body(vehicle);
    }

}
