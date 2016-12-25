package com.flashlogist.applications.rout;

import com.flashlogist.applications.global.Application;
import com.flashlogist.applications.admin.usermanager.user.dao.UserRole;

import java.util.Arrays;
import java.util.List;

public class RoutApplication implements Application {
    private List<UserRole> ADMIN_ACCESSES = Arrays.asList(UserRole.ADMIN, UserRole.USER);

    @Override
    public boolean isAvailableForRole(UserRole userRole) {
        return ADMIN_ACCESSES.stream()
                .anyMatch(role -> userRole == role);
    }

    @Override
    public String getUrl() {
        return "/rout";
    }

    @Override
    public String getName() {
        return "routManagement";
    }

    @Override
    public String getShowName() {
        return "Rout management";
    }
}
