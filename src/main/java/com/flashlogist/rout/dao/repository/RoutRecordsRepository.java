package com.flashlogist.rout.dao.repository;

import com.flashlogist.rout.dao.RoutRecord;
import com.flashlogist.vehicle.dao.Vehicle;

import java.time.LocalDate;
import java.util.Collection;

public interface RoutRecordsRepository {

    Collection<RoutRecord> getRecordsByVehicle(Vehicle vehicle, LocalDate from, LocalDate to);
}
