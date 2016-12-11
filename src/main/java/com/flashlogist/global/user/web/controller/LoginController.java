package com.flashlogist.global.user.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

import static org.springframework.security.core.context.SecurityContextHolder.getContext;

@Controller
@RequestMapping("/login")
public class LoginController {

    @ModelAttribute(value = "principal")
    public String setPrincipal() {
        return null;
    }

    @GetMapping
    public ModelAndView loginForm(@RequestParam(value = "logout", required = false) String logout,
                                  @RequestParam(value = "error", required = false) String error) {
        ModelAndView modelAndView = new ModelAndView("login");

        if (logout != null) {
            modelAndView.addObject("message", "You was logged out");
        } else if (error != null) {
            modelAndView.addObject("message", "Wrong login or password");
        }

        return modelAndView;
    }
}
