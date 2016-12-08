package com.flashlogist.global.springcontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorPagesController {

    @GetMapping(value = "/403")
    public ModelAndView accessDenied() {
        return new ModelAndView("error403");
    }

}
