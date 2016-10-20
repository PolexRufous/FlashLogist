package com.flashlogist.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Lex on 20.10.2016.
 */

@Configuration
@EnableWebMvc
@ComponentScan("com.flashlogist.web.springcontrollers")
public class WebConfiguration extends WebMvcConfigurerAdapter {



}
