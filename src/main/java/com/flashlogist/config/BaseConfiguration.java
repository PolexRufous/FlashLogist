package com.flashlogist.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.Collections;

/**
 * Created by Lex on 20.10.2016.
 */

@Configuration
public class BaseConfiguration {

    /**
     * Base JSON mapper
     *
     * @return new instance of MappingJackson2JsonView.class
     */
    @Bean
    public MappingJackson2JsonView getMappingJackson2JsonView() {
        return new MappingJackson2JsonView();
    }

}
