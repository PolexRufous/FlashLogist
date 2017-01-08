package com.flashlogist.applications.global;


import com.flashlogist.applications.admin.usermanager.user.dao.UserRole;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service(value = "applicationUtils")
public class ApplicationUtils {

    @Resource(name = "adminApplication")
    private Application adminApplication;

    @Resource(name = "routApplication")
    private Application routApplication;

    @Resource(name = "profileApplication")
    private Application profileApplication;


    private Map<String, Application> applicationMap = new ConcurrentHashMap<>();

    public ApplicationUtils() {

    }

    @PostConstruct
    private void initApplicationsMap() {
        applicationMap.put(adminApplication.getName(), adminApplication);
        applicationMap.put("rout", routApplication);
        applicationMap.put(profileApplication.getName(), profileApplication);
    }

    public List<Application> getApplicationsForRole(UserRole userRole) {
        return applicationMap.values().stream()
                .filter(application -> application.isAvailableForRole(userRole))
                .collect(Collectors.toList());
    }




}
