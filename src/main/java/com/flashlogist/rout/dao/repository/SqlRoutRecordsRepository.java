package com.flashlogist.rout.dao.repository;

import com.flashlogist.rout.dao.RoutRecord;
import com.flashlogist.rout.dao.RoutRecord_;
import com.flashlogist.vehicle.dao.Vehicle;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<RoutRecord> criteria = builder.createQuery(RoutRecord.class);
        Root<RoutRecord> root = criteria.from(RoutRecord.class);

        criteria.select(root)
                .where(builder.equal(root.get(RoutRecord_.vehicle), vehicle))
                .where(builder.equal(root.get(RoutRecord_.startingDate), from))
                .where(builder.equal(root.get(RoutRecord_.endingDate), to));

        return entityManager.createQuery(criteria).getResultList();
    }
}
