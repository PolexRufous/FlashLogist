package com.flashlogist.applications.global;

import com.flashlogist.applications.admin.usermanager.user.dao.UserRole;

public interface Application {
    boolean isAvailableForRole(UserRole userRole);
    String getUrl();
    String getName();
    String getShowName();
}
