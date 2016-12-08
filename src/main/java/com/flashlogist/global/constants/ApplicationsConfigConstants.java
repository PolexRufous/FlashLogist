package com.flashlogist.global.constants;

import org.springframework.beans.factory.annotation.Value;

public class ApplicationsConfigConstants {

    //Admin Application
    @Value("${application.admin.available}")
    public static Boolean ADMIN_AVAILABLE;

    @Value("${application.admin.access}")
    public static String ADMIN_ACCESSES_LINE;
    public static String[] ADMIN_ACCESSES;


    //fields initializing if needed
    static {
        ADMIN_ACCESSES = ADMIN_ACCESSES_LINE.split(",");
    }
}
