package com.flashlogist.applications.global;


import com.flashlogist.applications.admin.AdminApplication;
import com.flashlogist.global.user.dao.UserRole;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ApplicationUtils {

    private static Map<String, Application> applicationMap = new ConcurrentHashMap<>();

    static {
        applicationMap.put("admin", new AdminApplication());
    }

    public static List<Application> getApplicationsForRole(UserRole userRole) {
        return applicationMap.entrySet().stream()
                .filter(entry -> entry.getValue().isAvailableForRole(userRole))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }


}
