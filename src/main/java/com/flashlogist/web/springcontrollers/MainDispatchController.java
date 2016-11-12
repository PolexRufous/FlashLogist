package com.flashlogist.web.springcontrollers;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

import static org.springframework.security.core.context.SecurityContextHolder.getContext;

@Controller
@RequestMapping("/main")
public class MainDispatchController {


    @GetMapping
    public String mainDispatch() {
        if (isUserAvailable()) {
            if (hasUserAuthority("ADMIN")) {
                return "redirect:/admin";
            } else if (hasUserAuthority("USER")) {
                return "redirect:/user";
            } else {
                return "redirect:/other";
            }
        } else {
            return "redirect:/403";
        }
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
