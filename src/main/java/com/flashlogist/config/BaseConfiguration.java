package com.flashlogist.config;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Configuration
@ComponentScan(value = {
        "com.flashlogist"
})
@PropertySources({
        @PropertySource({"classpath:applications/applications.properties"})
})
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

    //To resolve ${} in @Value
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
