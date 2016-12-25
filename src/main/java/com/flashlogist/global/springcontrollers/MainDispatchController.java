package com.flashlogist.global.springcontrollers;

import com.flashlogist.applications.global.Application;
import com.flashlogist.applications.global.ApplicationUtils;
import com.flashlogist.applications.admin.usermanager.user.dao.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.security.core.context.SecurityContextHolder.getContext;

@Controller
@RequestMapping("/main")
public class MainDispatchController {


    @GetMapping
    public String mainDispatch() {
        if (isUserAvailable()) {
            return "main";
        }

        return "redirect:/403";
    }

    @ModelAttribute(value = "principal")
    public String setPrincipal() {
        return ((User) getContext().getAuthentication().getPrincipal()).getUsername();
    }

    @ModelAttribute(value = "applications")
    public List<Application> setApplications() {
        return getContext().getAuthentication().getAuthorities().stream()
                .map(authority -> ApplicationUtils.getApplicationsForRole(UserRole.valueOf(authority.getAuthority())))
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }


    @SuppressWarnings("unchecked")
    private boolean hasUserAuthority(String authority) {

        boolean result = false;

        try {
            Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>)
                    getContext().getAuthentication().getAuthorities();
            for (GrantedAuthority gAuthority : authorities) {
                result = gAuthority.getAuthority().equals(authority);
                if (result) {
                    break;
                }
            }
        } catch (NullPointerException ignore) {
        }
        return result;
    }

    private boolean isUserAvailable() {
        try {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().
                    getAuthentication().getPrincipal();
            return userDetails.isEnabled();
        } catch (NullPointerException e) {
            return false;
        }
    }

}
