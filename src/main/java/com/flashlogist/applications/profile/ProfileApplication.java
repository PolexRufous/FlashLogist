package com.flashlogist.applications.profile;


import com.flashlogist.applications.admin.usermanager.user.dao.UserRole;
import com.flashlogist.applications.global.Application;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("profileApplication")
public class ProfileApplication implements Application {

    @Value("${application.profile.url}")
    private String PROFILE_URL;
    @Value("${application.profile.name}")
    private String PROFILE_NAME;
    @Value("${application.profile.display.name}")
    private String PROFILE_SHOW_NAME;
    @Value("${application.profile.available}")
    private String PROFILE_AVAILABLE;

    @Override
    public boolean isAvailableForRole(UserRole userRole) {
        return Boolean.parseBoolean(PROFILE_AVAILABLE);
    }

    @Override
    public String getUrl() {
        return PROFILE_URL;
    }

    @Override
    public String getName() {
        return PROFILE_NAME;
    }

    @Override
    public String getShowName() {
        return PROFILE_SHOW_NAME;
    }
}
