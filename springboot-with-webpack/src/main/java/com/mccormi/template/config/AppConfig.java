package com.mccormi.template.config;

import com.google.common.collect.Lists;
import com.mccormi.template.util.BuildVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import java.util.List;

@Configuration
public class AppConfig {
  
  @Autowired
  @Bean(name = "BuildVersion")
  public BuildVersion getBuildVersion(Environment environment) {
    BuildVersion result = new BuildVersion();
    String[] profileArray = environment.getActiveProfiles();
    List<String> profiles = Lists.newArrayList();
    for (String profile : profileArray) {
      profiles.add(profile);
    }
    
    result.setProfiles(profiles);
    return result;
  }
  
}
