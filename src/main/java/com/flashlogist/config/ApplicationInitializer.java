package com.flashlogist.config;

import com.flashlogist.global.constants.ApplicationsConfigConstants;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{
                RestConfiguration.class,
                BaseConfiguration.class,
                WebSecurityConfiguration.class,
                DatabaseHibernateConfiguration.class,
                ApplicationsConfigConstants.class
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{
                WebConfiguration.class
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{
                "/",
        };
    }
}
