package com.flashlogist.global.springcontrollers;

import com.flashlogist.config.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.Filter;
import java.util.Collection;
import java.util.LinkedList;

import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.nullValue;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        WebConfiguration.class,
        BaseConfiguration.class,
        WebSecurityConfiguration.class,
        DatabaseHibernateConfiguration.class,
        RestConfiguration.class
})
@WebAppConfiguration
public class LoginControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private Filter springSecurityFilterChain;

    @Before
    public void setUp() {
        //We have to reset our mock between tests because the mock objects
        //are managed by the Spring container. If we would not reset them,
        //stubbing and verified behavior would "leak" from one test to another.
        //Mockito.reset(ServiceMock);
        mockMvc =
                MockMvcBuilders
                        .webAppContextSetup(webApplicationContext)
                        .addFilters(springSecurityFilterChain)
                        .build();
    }

    private Collection<GrantedAuthority> adminAuthority() {
        return getAuthority("ADMIN");
    }

    private Collection<GrantedAuthority> userAuthority() {
        return getAuthority("USER");
    }

    private Collection<GrantedAuthority> getAuthority(String authority) {
        Collection<GrantedAuthority> result = new LinkedList<>();
        result.add(new SimpleGrantedAuthority(authority));
        return result;
    }

    @Test
    public void testEmptyLogin() throws Exception {
        mockMvc.perform(
                get("/login")
        )
                .andExpect(status().isOk())
                .andExpect(view().name("login"))
                .andExpect(forwardedUrl("/WEB-INF/jspages/login.jsp"))
                .andExpect(model().attribute("message", nullValue()));
    }

    @Test
    public void testLoginLogout() throws Exception {
        mockMvc.perform(
                get("/login")
                        .param("logout", "")
        )
                .andExpect(status().isOk())
                .andExpect(view().name("login"))
                .andExpect(forwardedUrl("/WEB-INF/jspages/login.jsp"))
                .andExpect(model().attribute("message", equalToIgnoringCase("You was logged out")));
    }

    @Test
    public void testLoginError() throws Exception {
        mockMvc.perform(
                get("/login")
                        .param("error", "")
        )
                .andExpect(status().isOk())
                .andExpect(view().name("login"))
                .andExpect(forwardedUrl("/WEB-INF/jspages/login.jsp"))
                .andExpect(model().attribute("message", equalToIgnoringCase("Wrong login or password")));
    }

    @Test
    public void testLoginAdmin() throws Exception {
        mockMvc.perform(
                formLogin()
                        .user("admin")
                        .password("admin")
        )
                .andExpect(
                        authenticated()
                                .withAuthorities(
                                        adminAuthority()
                                )
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/main"));
    }

    @Test
    public void testLoginUser() throws Exception {
        mockMvc.perform(
                formLogin()
                        .user("user")
                        .password("user")
        )
                .andExpect(
                        authenticated()
                                .withAuthorities(
                                        userAuthority()
                                )
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/main"));
    }

    @Test
    public void testLoginWrongUser() throws Exception {
        mockMvc.perform(
                formLogin()
                        .user("userwrong")
                        .password("user")
        )
                .andExpect(unauthenticated());
    }

    @Test
    public void testLoginWrongPassword() throws Exception {
        mockMvc.perform(
                formLogin()
                        .user("user")
                        .password("wrong")
        )
                .andExpect(unauthenticated());
    }

    @Test
    public void testLoginLockedUser() throws Exception {
        mockMvc.perform(
                formLogin()
                        .user("locked")
                        .password("locked")
        )
                .andExpect(unauthenticated());
    }

}
