package com.flashlogist.applications.global;


import com.flashlogist.applications.admin.AdminApplication;
import com.flashlogist.applications.rout.RoutApplication;
import com.flashlogist.global.user.dao.UserRole;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ApplicationUtils {

    private static Map<String, Application> applicationMap = new ConcurrentHashMap<>();

    static {
        applicationMap.put("admin", new AdminApplication());
        applicationMap.put("rout", new RoutApplication());
    }

    public static List<Application> getApplicationsForRole(UserRole userRole) {
        return applicationMap.values().stream()
                .filter(application -> application.isAvailableForRole(userRole))
                .collect(Collectors.toList());
    }


}
