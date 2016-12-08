package com.flashlogist.global.user.dao.repository;

import com.flashlogist.global.user.dao.User;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * for testing only
 */
@Profile("stubs")
@Repository("userRepository")
public class InMemoryUserRepository implements UserRepository {
    private Map<Long, User> users;

    public InMemoryUserRepository() {
        users = new HashMap<>();
        users.put(1L, createUser(1L));
        users.put(2L, createUser(2L));
        users.put(3L, createUser(3L));
        users.put(4L, createUser(4L));
        users.put(5L, createUser(5L));
        users.put(6L, createUser(6L));
    }

    private User createUser(Long id) {
        User user = new User();
        user.setFirstName("John" + id);
        user.setLastName("Lewis" + id);
        user.setId(id);
        user.setPassword("123");
        return user;
    }


    @Override
    public Collection<User> getAll() {
        return users.values();
    }

    @Override
    public User getUserById(Long id) {
        return users.get(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return users.values().stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .get();
    }

    @Override
    public void save(User user) {

    }
}
