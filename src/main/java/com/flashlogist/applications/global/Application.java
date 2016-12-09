package com.flashlogist.applications.global;

import com.flashlogist.global.user.dao.UserRole;

public interface Application {
    boolean isAvailableForRole(UserRole userRole);
    String getURL();
    String getName();
    String getShowName();
}
