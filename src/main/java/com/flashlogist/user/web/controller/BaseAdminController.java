package com.flashlogist.user.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class BaseAdminController {

    @GetMapping
    public ModelAndView mainPage() {
        return new ModelAndView("adminMain");
    }

}
