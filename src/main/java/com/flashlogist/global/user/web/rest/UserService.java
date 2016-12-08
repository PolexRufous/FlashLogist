package com.flashlogist.global.user.web.rest;

import com.flashlogist.global.user.dao.User;
import com.flashlogist.global.user.domain.UserManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.ws.rs.Produces;
import java.util.Collection;

@RestController
@RequestMapping("/rest/user")
public class UserService {

    @Resource(name = "userManager")
    UserManager userManager;

    @GetMapping
    @ResponseBody
    @Produces(value = "application/json")
    public ResponseEntity getAll() {
        Collection users = userManager.getAll();
        if (users.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(201).body(users);
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    @Produces(value = "application/json")
    public ResponseEntity getById(@PathVariable("id") Long id) {
        User user = userManager.getUserById(id);
        if (user == null) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(201).body(user);
    }

}
