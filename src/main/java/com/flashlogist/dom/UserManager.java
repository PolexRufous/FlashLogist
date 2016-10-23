package com.flashlogist.dom;

import com.flashlogist.database.dao.user.UserRepository;
import com.flashlogist.database.entities.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service(value = "userManager")
public class UserManager {

    @Autowired
    private UserRepository userRepository;

    public Collection<User> getAll() {
        return userRepository.getAll();
    }

    public User getUserById(Long id) {
        return userRepository.getUserById(id);
    }

    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }
}
