package com.flashlogist.config;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.io.IOException;
import java.util.Properties;

@Configuration
@ComponentScan(value = {
        "com.flashlogist"
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
    public PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer =
        new PropertySourcesPlaceholderConfigurer();
        propertySourcesPlaceholderConfigurer
                .setLocation(new ClassPathResource("applications/applications.properties"));

        return propertySourcesPlaceholderConfigurer;
    }

/*    @Bean(name = "applicationProperties")
    public Properties properties() throws IOException {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setSingleton(true);
        propertiesFactoryBean
                .setLocation(new ClassPathResource("applications/applications.properties"));
        propertiesFactoryBean.afterPropertiesSet();
        return propertiesFactoryBean.getObject();
    }*/

}
