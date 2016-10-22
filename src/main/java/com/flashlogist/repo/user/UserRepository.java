package com.flashlogist.repo.user;

import com.flashlogist.dom.user.User;

import java.util.Collection;

public interface UserRepository {
    Collection<User> getAll();

    User getUserById(Long id);

    User getUserByEmail(String email);
}
