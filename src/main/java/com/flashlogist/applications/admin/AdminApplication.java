package com.flashlogist.applications.admin;

import com.flashlogist.applications.global.Application;
import com.flashlogist.config.BaseConfiguration;
import com.flashlogist.global.user.dao.UserRole;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@Configurable
public class AdminApplication implements Application {

    @Value("${application.admin.access}")
    private String adminAccess;

    @Value("${application.admin.url}")
    private String adminUrl;

    @Value("${application.admin.name}")
    private String adminName;

    @Value("${application.admin.display.name}")
    private String adminShowName;

    @Value("${application.admin.available}")
    private String adminAvailable;



    public AdminApplication() {
    }

    @Override
    public boolean isAvailableForRole(UserRole userRole) {
        List<String> ADMIN_ACCESSES = Arrays.asList(adminAccess.split(","));
        return Boolean.getBoolean(adminAvailable)
                && ADMIN_ACCESSES.stream().anyMatch(role -> userRole.toString().equalsIgnoreCase(role));
    }

    @Override
    public String getUrl() {
        return adminUrl;
    }

    @Override
    public String getName() {
        return adminName;
    }

    @Override
    public String getShowName() {
        return adminShowName;
    }
}
