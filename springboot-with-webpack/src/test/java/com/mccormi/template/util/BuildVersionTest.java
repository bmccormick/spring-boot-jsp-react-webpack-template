package com.mccormi.template.util;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BuildVersionTest {
  
  private BuildVersion buildVersion;
  
  @BeforeEach
  public void setUp() throws Exception {
    buildVersion = new BuildVersion();
  }
  
  @Test
  public void checkProfile() throws Exception {
    buildVersion.setProfiles(Lists.newArrayList("abc"));
    
    Assertions.assertTrue(buildVersion.checkProfile("abc"));
    Assertions.assertFalse(buildVersion.checkProfile("dev"));
  }
  
  @Test
  public void isDev() throws Exception {
    buildVersion.setProfiles(Lists.newArrayList("dev"));
    
    Assertions.assertTrue(buildVersion.checkProfile("dev"));
  }
  
}
