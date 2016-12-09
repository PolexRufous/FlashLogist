package com.flashlogist.applications.admin;

import com.flashlogist.applications.global.Application;
import com.flashlogist.global.user.dao.UserRole;
import org.springframework.beans.factory.annotation.Value;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AdminApplication implements Application {

    @Value("${application.admin.available}")
    private Boolean ADMIN_AVAILABLE;

    @Value("${application.admin.access}")
    private String ADMIN_ACCESSES_LINE;
    private List<String> ADMIN_ACCESSES;

    @Value("${application.admin.url}")
    private String ADMIN_URL;

    @Value("${application.admin.name}")
    private String ADMIN_NAME;

    @Value("${application.admin.display.name}")
    private String ADMIN_SHOW_NAME;


    public AdminApplication() {
        ADMIN_ACCESSES = Arrays.asList(ADMIN_ACCESSES_LINE.split(","));
    }

    @Override
    public boolean isAvailableForRole(UserRole userRole) {
        return ADMIN_ACCESSES.stream()
                .filter(role -> userRole.toString().equalsIgnoreCase(role))
                .collect(Collectors.toList())
                .isEmpty();
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
