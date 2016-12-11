package com.flashlogist.applications.global;

import com.flashlogist.global.user.dao.UserRole;

public interface Application {
    boolean isAvailableForRole(UserRole userRole);
    String getUrl();
    String getName();
    String getShowName();
}
