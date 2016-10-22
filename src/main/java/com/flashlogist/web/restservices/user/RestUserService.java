package com.flashlogist.web.restservices.user;

import com.flashlogist.dom.user.User;
import com.flashlogist.dom.user.UserManager;
import com.flashlogist.repo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/rest/user")
public class RestUserService {
    @Autowired
    UserManager userManager;

    @GetMapping
    @ResponseBody
    @Produces(value = "application/json")
    public ResponseEntity<Collection<User>> getAll() {
        return ResponseEntity.status(201).body(userManager.getAll());
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    @Produces(value = "application/json")
    public ResponseEntity<User> getById(@PathVariable("id") Long id) {
        return ResponseEntity.status(201).body(userManager.getUserById(id));
    }

}
