package com.flashlogist.applications.admin;

import com.flashlogist.applications.global.Application;
import com.flashlogist.global.user.dao.UserRole;

import java.util.Arrays;
import java.util.List;

public class AdminApplication implements Application {

    private List<UserRole> ADMIN_ACCESSES = Arrays.asList(UserRole.ADMIN);
    private String ADMIN_URL = "/admin";
    private String ADMIN_NAME = "admin";
    private String ADMIN_SHOW_NAME = "Admin";


    public AdminApplication() {
    }

    @Override
    public boolean isAvailableForRole(UserRole userRole) {
        return ADMIN_ACCESSES.stream()
                .filter(role -> userRole == role)
                .findAny()
                .isPresent();
    }

    @Override
    public String getURL() {
        return ADMIN_URL;
    }

    @Override
    public String getName() {
        return ADMIN_NAME;
    }

    @Override
    public String getShowName() {
        return ADMIN_SHOW_NAME;
    }
}
