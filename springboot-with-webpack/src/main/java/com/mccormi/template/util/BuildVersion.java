package com.mccormi.template.util;

import com.google.common.collect.Lists;
import java.util.List;

public class BuildVersion {
  
  private List<String> profiles = Lists.newArrayList();
  
  public List<String> getProfiles() {
    return profiles;
  }
  
  public void setProfiles(List<String> profiles) {
    this.profiles = profiles;
  }
  
  public boolean checkProfile(String profile) {
    if (getProfiles().contains(profile)) {
      return true;
    }
    return false;
  }
  
  public boolean isDev() {
    if (getProfiles().contains("dev")) {
      return true;
    }
    return false;
  }
}
