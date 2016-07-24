package com.mccormi.template.util;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BuildVersionTest {

  private BuildVersion buildVersion;

  @Before
  public void setUp() throws Exception {
    buildVersion = new BuildVersion();
  }

  @Test
  public void checkProfile() throws Exception {
    buildVersion.setProfiles(Lists.newArrayList("abc"));

    Assert.assertTrue(buildVersion.checkProfile("abc"));
    Assert.assertFalse(buildVersion.checkProfile("dev"));
  }

  @Test
  public void isDev() throws Exception {
    buildVersion.setProfiles(Lists.newArrayList("dev"));

    Assert.assertTrue(buildVersion.checkProfile("dev"));
  }

}
