package com.flashlogist.web.restservices;

import com.flashlogist.dom.user.User;
import com.flashlogist.dom.user.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Produces;
import java.util.Collection;

@RestController
@RequestMapping("/rest/user")
public class UserService {
    @Autowired
    UserManager userManager;

    @GetMapping
    @ResponseBody
    @Produces(value = "application/json")
    public ResponseEntity getAll() {
        Collection users = userManager.getAll();
        if (users.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(201).body(userManager.getAll());
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
