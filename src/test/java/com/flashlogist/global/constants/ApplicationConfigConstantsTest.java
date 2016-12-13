package com.flashlogist.global.constants;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        ApplicationsConfigConstants.class
})
@WebAppConfiguration
public class ApplicationConfigConstantsTest {

    @Value("${application.admin.available}")
    private String adminAvailable;

    @Value("${application.admin.access}")
    private String adminAccess;

    @Test
    public void testExisting() throws Exception {
        assertNotNull("Variable not exist", adminAvailable);
    }

    @Test
    public void testValue() throws Exception {
        assertEquals("Variable has not expected value",
                "ADMIN", adminAccess);
    }
}
