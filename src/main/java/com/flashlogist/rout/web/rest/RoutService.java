package com.flashlogist.rout.web.rest;

import com.flashlogist.rout.domain.RouteRecordsManager;
import com.flashlogist.vehicle.dao.Vehicle;
import com.flashlogist.vehicle.domain.VehicleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Produces;
import java.time.LocalDate;
import java.util.Collection;

@RestController
@RequestMapping("/rest/rout")
public class RoutService {
    @Autowired
    RouteRecordsManager routRecordsManager;
    @Autowired
    VehicleManager vehicleManager;

    @GetMapping
    @ResponseBody
    @Produces(value = "application/json")
    public ResponseEntity getAll(@RequestParam(value = "vehicleId") Long vehicleId,
                                 @RequestParam(value = "startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                 @RequestParam(value = "endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        Vehicle vehicle = vehicleManager.getById(vehicleId);
        Collection routs = routRecordsManager.getRecordsByVehicle(vehicle, startDate, endDate);
        if (routs.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(201).body(routs);
    }
}
