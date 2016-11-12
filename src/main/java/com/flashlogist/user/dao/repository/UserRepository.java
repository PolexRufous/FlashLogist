package com.flashlogist.user.dao.repository;

import com.flashlogist.user.dao.User;

import java.util.Collection;

public interface UserRepository {
    Collection<User> getAll();

    User getUserById(Long id);

    User getUserByEmail(String email);
}
