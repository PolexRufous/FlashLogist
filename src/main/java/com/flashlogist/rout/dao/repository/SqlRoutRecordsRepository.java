package com.flashlogist.rout.dao.repository;

import com.flashlogist.rout.dao.RoutRecord;
import com.flashlogist.vehicle.dao.Vehicle;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.Collection;

@Repository("routRecordsRepository")
@Transactional
public class SqlRoutRecordsRepository implements RoutRecordsRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Collection<RoutRecord> getRecordsByVehicle(Vehicle vehicle, LocalDate from, LocalDate to) {
        TypedQuery<RoutRecord> query = entityManager.createQuery(
                "SELECT NEW com.flashlogist.rout.dao.RoutRecord(c) FROM com.flashlogist.rout.dao.RoutRecord AS c WHERE c.vehicle=vehicle", RoutRecord.class);
/*        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<RoutRecord> u = cb.createQuery(RoutRecord.class);
        Root<RoutRecord> fromRoutRecord = u.from(RoutRecord.class);
        TypedQuery<RoutRecord> allQuery = entityManager.createQuery(u.select(fromRoutRecord)
                .where(cb.equal(fromRoutRecord.get("starting_date"), from))
                .where(cb.equal(fromRoutRecord.get("ending_date"), to))
                .where(cb.equal(fromRoutRecord.get("vehicle_id"), vehicle.getId())));
        return allQuery.getResultList();*/
        return query.getResultList();
    }
}
