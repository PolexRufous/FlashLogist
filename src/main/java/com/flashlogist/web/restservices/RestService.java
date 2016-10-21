package com.flashlogist.web.restservices;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Produces;

/**
 * Created by Lex on 20.10.2016.
 */

@RestController
@RequestMapping("/rest")
public class RestService {

    @GetMapping
    @ResponseBody
    @Produces(value = "application/json")
    public ResponseEntity<SomeClass> getUser() {
        SomeClass someClass = new SomeClass();
        someClass.setOne("first");
        someClass.setTwo("second");
        return ResponseEntity.status(201).body(someClass);

    }

}
