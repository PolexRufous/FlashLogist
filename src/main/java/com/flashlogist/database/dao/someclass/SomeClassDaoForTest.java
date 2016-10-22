package com.flashlogist.database.dao.someclass;

import com.flashlogist.database.entities.someclass.SomeClass;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository("someClassDao")
@Transactional
public class SomeClassDaoForTest implements SomeClassDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public SomeClass save(SomeClass someClass) {
        return entityManager.merge(someClass);
    }

    @Override
    public SomeClass getById(long id) {
        return entityManager.find(SomeClass.class, id);
    }

    @Override
    public List<SomeClass> getAll() {
        return entityManager.createQuery(getBaseCriteriaQuery()).getResultList();
    }

    private CriteriaQuery<SomeClass> getBaseCriteriaQuery() {
        CriteriaQuery<SomeClass> criteria = entityManager.getCriteriaBuilder().
                createQuery(SomeClass.class);
        criteria.select(criteria.from(SomeClass.class));
        return criteria;
    }
}
