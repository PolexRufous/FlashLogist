package com.flashlogist.web.restservices;

import com.flashlogist.database.dao.someclass.SomeClassDao;
import com.flashlogist.database.entities.someclass.SomeClass;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.ws.rs.Produces;

/**
 * Created by Lex on 20.10.2016.
 */

@RestController
@RequestMapping("/rest")
public class RestService {

    @Resource(name = "someClassDao")
    private SomeClassDao someClassDao;

    @GetMapping
    @ResponseBody
    @Produces(value = "application/json")
    public ResponseEntity<SomeClass> getUser() {
        SomeClass someClass = new SomeClass();
        someClass.setOne("Hello");
        someClass.setTwo("World");

        someClass = someClassDao.save(someClass);

        return ResponseEntity.status(201).body(someClass);

    }

}
