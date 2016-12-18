package com.flashlogist.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication().dataSource(dataSource)
                    .usersByUsernameQuery(
                        "select login, password, available from GLOBAL_USER where login=?")
                    .authoritiesByUsernameQuery(
                        "select login, role from GLOBAL_USER where login=?");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .and()
                .authorizeRequests()
                    .antMatchers("/login").permitAll()
                        .antMatchers("/main").hasAnyAuthority("USER", "ADMIN")
                    .antMatchers("/admin/**").hasAuthority("ADMIN")
                    .antMatchers("/rout/**").hasAnyAuthority("USER", "ADMIN")
                    .antMatchers("/user/**").hasAnyAuthority("USER", "ADMIN")
                    .antMatchers("/rest/**").hasAnyAuthority("USER", "ADMIN")
                    .anyRequest().denyAll()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/main", true)
                .and()
                    .exceptionHandling()
                        .accessDeniedPage("/403");
    }

}
