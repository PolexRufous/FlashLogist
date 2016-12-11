package com.flashlogist.applications.admin;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.security.core.context.SecurityContextHolder.getContext;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @ModelAttribute(value = "principal")
    public String setPrincipal() {
        return ((User) getContext().getAuthentication().getPrincipal()).getUsername();
    }

    @GetMapping
    public ModelAndView adminPage() {
        return new ModelAndView("applications/admin/admin");
    }

}
