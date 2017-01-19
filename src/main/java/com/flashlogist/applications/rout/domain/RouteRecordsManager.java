package com.flashlogist.applications.rout.domain;

import com.flashlogist.applications.rout.dao.repository.RoutRecordsRepository;
import com.flashlogist.applications.rout.dao.RoutRecord;
import com.flashlogist.vehicle.dao.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;

@Service(value = "routRecordsManager")
public class RouteRecordsManager {
    private RoutRecordsRepository repository;

    @Autowired
    public RouteRecordsManager(RoutRecordsRepository repository) {
        this.repository = repository;
    }

    public Collection<RoutRecord> getRecordsByVehicle(Vehicle vehicle, LocalDate from, LocalDate to) {
        Collection<RoutRecord> records = repository.getRecordsByVehicle(vehicle, from, to);
        if(records == null)
            return Collections.emptyList();
        return records;
    }
}
