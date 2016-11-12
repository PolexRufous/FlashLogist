package com.flashlogist.vehicle.dao.repository;

import com.flashlogist.vehicle.dao.Vehicle;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.Collection;

@Repository("vehicleRepository")
@Transactional
public class VehicleRepositoryDatabase implements VehicleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public VehicleRepositoryDatabase() {

    }

    @Override
    public Collection<Vehicle> getAll() {
        return entityManager.createQuery(getBaseCriteriaQuery()).getResultList();
    }

    @Override
    public Vehicle getById(Long id) {
        return entityManager.find(Vehicle.class, id);
    }


    private CriteriaQuery<Vehicle> getBaseCriteriaQuery() {
        CriteriaQuery<Vehicle> criteria = entityManager.getCriteriaBuilder().
                createQuery(Vehicle.class);
        criteria.select(criteria.from(Vehicle.class));
        return criteria;
    }

}
