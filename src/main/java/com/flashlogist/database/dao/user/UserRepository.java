package com.flashlogist.database.dao.user;

import com.flashlogist.database.entities.user.User;

import java.util.Collection;

public interface UserRepository {
    Collection<User> getAll();

    User getUserById(Long id);

    User getUserByEmail(String email);
}
