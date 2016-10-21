package com.flashlogist.web.springcontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Lex on 21.10.2016.
 */

@Controller
public class ErrorPagesController {

    @GetMapping(value = "/403")
    public ModelAndView accessDenied() {
        return new ModelAndView("error403");
    }

}
