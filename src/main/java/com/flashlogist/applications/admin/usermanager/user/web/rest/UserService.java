package com.flashlogist.applications.admin.usermanager.user.web.rest;

import com.flashlogist.applications.admin.usermanager.user.dao.User;
import com.flashlogist.applications.admin.usermanager.user.domain.UserManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import java.util.Collection;

@RestController
@RequestMapping("/rest/user")
public class UserService {

    @Resource(name = "userManager")
    private UserManager userManager;

    @GetMapping
    @ResponseBody
    @Produces(value = "application/json")
    public ResponseEntity getAll() {
        Collection users = userManager.getAll();
        if (users.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(users);
    }

    @GetMapping("/{id}")
    @ResponseBody
    @Produces(value = "application/json")
    public ResponseEntity getById(@PathVariable("id") Long id) {
        User user = userManager.getUserById(id);
        if (user == null) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(user);
    }

    @PostMapping
    @ResponseBody
    @Consumes(value = "application/json")
    @Produces(value = "application/json")
    public ResponseEntity save(@RequestBody User user) {
        if (user != null) {
            User responseUser = userManager.save(user);
            return ResponseEntity.status(201).body(responseUser);
        } else {
            return ResponseEntity.status(403).build();
        }
    }

    @PutMapping("/{id}")
    @ResponseBody
    @Consumes(value = "application/json")
    @Produces(value = "application/json")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody User user) {
        if (user != null) {
            User responseUser = userManager.update(user);
            return ResponseEntity.status(202).body(responseUser);
        } else {
            return ResponseEntity.status(403).build();
        }
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @Consumes(value = "application/json")
    @Produces(value = "application/json")
    public ResponseEntity delete(@PathVariable("id") Long id, @RequestBody User user) {
        if (id != null && id != 0) {
            userManager.delete(user);
            return ResponseEntity.status(202).build();
        } else {
            return ResponseEntity.status(403).build();
        }
    }



}
