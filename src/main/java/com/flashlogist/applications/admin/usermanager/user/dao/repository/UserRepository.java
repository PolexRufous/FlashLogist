package com.flashlogist.applications.admin.usermanager.user.dao.repository;

import com.flashlogist.applications.admin.usermanager.user.dao.User;

import java.util.Collection;

public interface UserRepository {
    Collection<User> getAll();
    User getUserById(Long id);
    User getUserByEmail(String email);
    User save(User user);
    void delete(User user);
    User update(User user);
}
