package com.flashlogist.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.Enumeration;
import java.util.Properties;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        BaseConfiguration.class
})
@WebAppConfiguration
public class BaseConfigurationTest {

    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    @Resource(name = "applicationProperties")
    private Properties properties;

    @Test
    public void testPropertyExist() throws Exception {
        //when
        String value = properties.getProperty("application.admin.access");

        //then
        assertNotNull("Returns null value that not expected", value);
        assertEquals("Incorrect value returned", "ADMIN", value);


    }

}

