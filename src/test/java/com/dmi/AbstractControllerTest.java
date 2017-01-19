package com.dmi;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * 
 * <h3>DMI Robson's Test</h3>
 * 
 * This class Abstract Tests implementation. 
 * 
 * @author Robson Martins
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public abstract class AbstractControllerTest{

    protected transient MockMvc mvc;

    @Autowired
    protected transient WebApplicationContext webApplicationContext;

    /**
     * Prepares the test class for execution of web tests
     */
    @Before
    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

}
