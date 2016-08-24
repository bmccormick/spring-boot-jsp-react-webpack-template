package com.mccormi.template.util;

import com.google.common.base.Throwables;
import com.google.common.collect.Lists;
import com.google.common.io.Closeables;
import com.google.common.io.Resources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Properties;

public class BuildVersion {
  
  private static Logger logger = LoggerFactory.getLogger(BuildVersion.class);
  
  private Properties gitProperties;
  
  public BuildVersion() {
    URL resource = null;
    try {
      resource = Resources.getResource("git.properties");
    } catch (Exception e) {
      logger.error("Unable to load git properties - {}", e.getMessage());
    }
    
    if (resource != null) {
      gitProperties = new Properties();
      InputStream inputStream = null;
      try {
        try {
          inputStream = resource.openStream();
          gitProperties.load(inputStream);
          for (String key : gitProperties.stringPropertyNames()) {
            gitProperties.put(key, gitProperties.getProperty(key).trim());
          }
        } finally {
          Closeables.close(inputStream, true);
        }
      } catch (IOException e) {
        logger.error("Unable to load git properties resource {}", e.getMessage());
        throw Throwables.propagate(e);
      }
    }
  }
  
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
  
  public String getGitVersion() {
    if (gitProperties != null) {
      return gitProperties.getProperty("git.commit.id", "unknown");
    }
    return "unknown";
  }
  
  public String getGitMessage() {
    if (gitProperties != null) {
      return gitProperties.getProperty("git.commit.message.full", "unknown");
    }
    return "unknown";
  }
  
  public String getGitEmail() {
    if (gitProperties != null) {
      return gitProperties.getProperty("git.commit.user.email", "unknown");
    }
    return "unknown";
  }
  
  public String getGitBranch() {
    if (gitProperties != null) {
      return gitProperties.getProperty("git.branch", "unknown");
    }
    return "unknown";
  }
  
  public String getGitDirty() {
    if (gitProperties != null) {
      return gitProperties.getProperty("git.dirty", "unknown");
    }
    return "unknown";
  }
  
  public String getGitBuildTime() {
    if (gitProperties != null) {
      return gitProperties.getProperty("git.build.time", "unknown");
    }
    return "unknown";
  }
  
}
