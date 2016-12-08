package com.flashlogist.global.user.domain;

import com.flashlogist.global.user.dao.repository.UserRepository;
import com.flashlogist.global.user.dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service(value = "userManager")
public class UserManager {

    private UserRepository userRepository;

    @Autowired
    public UserManager(UserRepository userRepository){
        this.userRepository = userRepository;
    }

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