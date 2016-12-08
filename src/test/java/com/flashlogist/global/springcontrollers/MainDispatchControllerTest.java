package com.flashlogist.global.springcontrollers;

import com.flashlogist.config.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.Filter;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.testSecurityContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        WebConfiguration.class,
        BaseConfiguration.class,
        WebSecurityConfiguration.class,
        DatabaseHibernateConfiguration.class,
        RestConfiguration.class
})
@WebAppConfiguration
public class MainDispatchControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private Filter springSecurityFilterChain;

    @Before
    public void setUp() {
        mockMvc =
                MockMvcBuilders
                        .webAppContextSetup(webApplicationContext)
                        .addFilters(springSecurityFilterChain)
                        .defaultRequest(get("/main").with(testSecurityContext()))
                        .build();
    }

    @Test
    @WithMockUser(authorities = {
            "ADMIN",
            "USER"
    })
    public void testMainAdmin() throws Exception {
        mockMvc.perform(
                    get("/main")
                    )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/admin"));
    }

    @Test
    @WithMockUser(authorities = {
            "USER"
    })
    public void testMainUser() throws Exception {
        mockMvc.perform(
                get("/main")
        )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/user"));
    }

    @Test
    @WithMockUser(authorities = {
            "OTHER"
    })
    public void testMainNoone() throws Exception {
        mockMvc.perform(
                get("/main")
        )
                .andExpect(status().is4xxClientError());
    }

}
