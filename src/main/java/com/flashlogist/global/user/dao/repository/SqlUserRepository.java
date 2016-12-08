package com.flashlogist.global.user.dao.repository;

import com.flashlogist.global.user.dao.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collection;

@Repository("userRepository")
@Transactional
public class SqlUserRepository implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Collection<User> getAll() {
        CriteriaQuery<User> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(User.class);
        TypedQuery<User> allQuery = entityManager.createQuery(criteriaQuery.select(criteriaQuery.from(User.class)));
        return allQuery.getResultList();
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User getUserByEmail(String email) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> u = cb.createQuery(User.class);
        Root<User> fromUser = u.from(User.class);
        TypedQuery<User> allQuery = entityManager.createQuery(u.select(fromUser).where(cb.equal(fromUser.get("email"), email)));
        return allQuery.getSingleResult();
    }

    @Override
    public void save(User user) {

    }

//    @Override
//    public User update(User user) {
//        return entityManager.merge(user);
//    }
//
//    @Override
//    public void save(User user) {
//        entityManager.persist(user);
//    }
//
//    @Override
//    public void delete(User user) {
//        entityManager.remove(user);
//    }
}
