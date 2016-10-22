package com.flashlogist.web.restservices;

import com.flashlogist.dom.vehicle.Vehicle;
import com.flashlogist.dom.vehicle.VehicleManager;
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
    public ResponseEntity<Collection<Vehicle>> getAll() {
        return ResponseEntity.status(201).body(vehicleManager.getAll());
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    @Produces(value = "application/json")
    public ResponseEntity<Vehicle> getById(@PathVariable("id") Long id) {
        return ResponseEntity.status(201).body(vehicleManager.getById(id));
    }

}
