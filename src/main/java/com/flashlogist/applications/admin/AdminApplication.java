package com.flashlogist.applications.admin;

import com.flashlogist.applications.global.Application;
import com.flashlogist.global.user.dao.UserRole;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class AdminApplication implements Application {

    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    @Resource(name = "applicationProperties")
    private Properties properties;

    private List<UserRole> ADMIN_ACCESSES = Arrays.asList(UserRole.ADMIN, UserRole.USER);

    public AdminApplication() {
    }

    @Override
    public boolean isAvailableForRole(UserRole userRole) {
        return Boolean.getBoolean(properties.getProperty("application.admin.available"))
                && ADMIN_ACCESSES.stream().anyMatch(role -> userRole == role);
    }

    @Override
    public String getUrl() {
        return properties.getProperty("application.admin.url");
    }

    @Override
    public String getName() {
        return properties.getProperty("application.admin.name");
    }

    @Override
    public String getShowName() {
        return properties.getProperty("application.admin.display.name");
    }
}
