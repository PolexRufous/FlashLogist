package com.flashlogist.web.springcontrollers.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class BaseUserController {

    @GetMapping
    public ModelAndView mainPage() {
        return new ModelAndView("userMain");
    }
}
