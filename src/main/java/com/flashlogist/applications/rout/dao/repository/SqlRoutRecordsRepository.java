package com.flashlogist.applications.rout.dao.repository;

import com.flashlogist.applications.admin.usermanager.user.dao.User;
import com.flashlogist.applications.rout.dao.RoutRecord;
import com.flashlogist.applications.rout.dao.RoutRecord_;
import com.flashlogist.vehicle.dao.Vehicle;
import org.springframework.beans.factory.annotation.Value;
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
    @Value("${application.rout.days_to_display}")
    private int daysToReturn;

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

    @Override
    public Collection<RoutRecord> getRecordsByUser(User user, LocalDate from, LocalDate to) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<RoutRecord> criteria = builder.createQuery(RoutRecord.class);
        Root<RoutRecord> root = criteria.from(RoutRecord.class);

        criteria.multiselect(root)
                .where(builder.equal(root.get(RoutRecord_.sender), user))
                .where(builder.equal(root.get(RoutRecord_.startingDate), from))
                .where(builder.equal(root.get(RoutRecord_.endingDate), to))
                .multiselect(root)
                .where(builder.equal(root.get(RoutRecord_.receiver), user))
                .where(builder.equal(root.get(RoutRecord_.startingDate), from))
                .where(builder.equal(root.get(RoutRecord_.endingDate), to));

        return entityManager.createQuery(criteria).getResultList();
    }

    public Collection<RoutRecord> getRecordsByUser(User user) {
        LocalDate to = LocalDate.now();
        LocalDate from = to.minusDays(daysToReturn);
        return getRecordsByUser(user, from, to);
    }

}
