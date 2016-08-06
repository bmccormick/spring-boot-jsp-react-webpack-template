package com.mccormi.template.controller;

import com.mccormi.template.config.TestAppConfig;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestAppConfig.class)
@WebAppConfiguration
public class TestHomepageController {
  
  private MockMvc mockMvc;
  
  @Autowired
  private HomepageController controller;
  
  @Before
  public void setup() {
    
  }
  
}
