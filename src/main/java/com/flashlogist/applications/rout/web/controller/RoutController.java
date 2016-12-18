package com.flashlogist.applications.rout.web.controller;

import com.flashlogist.applications.rout.app_wide.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequestMapping("/rout")
public class RoutController {


    @GetMapping
    public ModelAndView mainRoutPage(ModelAndView model, Principal principal) {
        model.setViewName(Page.ROUT_MAIN.getView());
        model.addObject("userName", principal.getName());
        return model;
    }
}
