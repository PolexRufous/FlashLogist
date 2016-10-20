package com.flashlogist.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * Created by Lex on 20.10.2016.
 */

@Configuration
public class RestConfiguration {

    @Bean
    public MappingJackson2JsonView getMappingJackson2JsonView() {
        return new MappingJackson2JsonView();
    }

    @Bean
    public ContentNegotiatingViewResolver getContentNegotiatingViewResolver() {
        return new ContentNegotiatingViewResolver();
    }

}
