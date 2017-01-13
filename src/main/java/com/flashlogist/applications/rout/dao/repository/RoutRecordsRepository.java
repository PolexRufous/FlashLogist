package com.flashlogist.applications.rout.dao.repository;

import com.flashlogist.applications.admin.usermanager.user.dao.User;
import com.flashlogist.applications.rout.dao.RoutRecord;
import com.flashlogist.vehicle.dao.Vehicle;

import java.time.LocalDate;
import java.util.Collection;

public interface RoutRecordsRepository {

    Collection<RoutRecord> getRecordsByVehicle(Vehicle vehicle, LocalDate from, LocalDate to);

    Collection<RoutRecord> getRecordsByUser(User user, LocalDate from, LocalDate to);

    Collection<RoutRecord> getRecordsByUser(User user);
}
