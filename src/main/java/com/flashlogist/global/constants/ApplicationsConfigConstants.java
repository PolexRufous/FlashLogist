package com.flashlogist.global.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource({"classpath:applications/applications.properties"})
public class ApplicationsConfigConstants {


    //ADMIN APPLICATION
    @Value("${application.admin.available}")
    public static String ADMIN_AVAILABLE;

    @Value("${application.admin.access}")
    public static String ADMIN_ACCESSES_LINE;

    @Value("${application.admin.url}")
    public static String ADMIN_URL;

    @Value("${application.admin.name}")
    public static String ADMIN_NAME;

    @Value("${application.admin.display.name}")
    public static String ADMIN_SHOW_NAME;

}
