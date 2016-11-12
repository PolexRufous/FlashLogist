package com.flashlogist.web.springcontrollers.admin;

import com.flashlogist.web.restservices.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("/admin")
public class BaseAdminController {

    @Resource
    private UserService userService;

    @GetMapping
    public ModelAndView mainPage() {
        return new ModelAndView("adminMain");
    }

}
