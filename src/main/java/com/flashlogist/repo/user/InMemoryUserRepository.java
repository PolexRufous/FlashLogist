package com.flashlogist.repo.user;

import com.flashlogist.dom.user.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * for testing only
 */
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
}
