package com.flashlogist.applications.rout.web.controller;

import com.flashlogist.applications.admin.usermanager.user.dao.User;
import com.flashlogist.applications.admin.usermanager.user.domain.UserManager;
import com.flashlogist.applications.rout.app_wide.Page;
import com.flashlogist.applications.rout.dao.RoutRecord;
import com.flashlogist.applications.rout.dao.repository.RoutRecordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Collection;

@Controller
@RequestMapping("/rout")
public class RoutController {
    @Autowired
    private RoutRecordsRepository routRecordsRepository;
    @Autowired
    private UserManager userManager;

    @GetMapping
    public ModelAndView mainRoutPage(ModelAndView model, Principal principal) {
        model.setViewName(Page.ROUT_MAIN.getView());
        User user = userManager.getUserByLogin(principal.getName());
        Collection<RoutRecord> routRecords = routRecordsRepository.getRecordsByUser(user);
        model.addObject("routs", routRecords);
        return model;
    }
}
