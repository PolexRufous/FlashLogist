package com.flashlogist.global.user.dao.repository;

import com.flashlogist.global.user.dao.User;

import java.util.Collection;

public interface UserRepository {
    Collection<User> getAll();

    User getUserById(Long id);

    User getUserByEmail(String email);

    void save(User user);
}
