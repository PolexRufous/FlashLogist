package com.flashlogist.dom.user;

import com.flashlogist.repo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
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
