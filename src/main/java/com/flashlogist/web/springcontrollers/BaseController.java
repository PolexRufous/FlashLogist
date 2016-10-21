package com.flashlogist.web.springcontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Lex on 20.10.2016.
 */

@Controller
@RequestMapping("/main")
public class BaseController {

    @GetMapping
    public ModelAndView helloWorld() {
        return new ModelAndView("main");
    }

}
