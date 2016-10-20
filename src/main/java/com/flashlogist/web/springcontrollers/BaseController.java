package com.flashlogist.web.springcontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;

/**
 * Created by Lex on 20.10.2016.
 */

@Controller
@RequestMapping("/")
public class BaseController {

    @GetMapping
    @ResponseBody
    public String helloWorld() {
        return "Hello world!";
    }

    @GetMapping("/smbd")
    @ResponseBody
    public String helloSmbd() {
        return "Hello somebody!";
    }

}
