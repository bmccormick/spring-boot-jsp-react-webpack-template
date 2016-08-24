package com.mccormi.template.controller;

import com.mccormi.template.util.BuildVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomepageController {
  
  @Autowired
  private BuildVersion buildVersion;
  
  @RequestMapping("/")
  public ModelAndView home() {
    return new ModelAndView("homepage");
  }
  
  @RequestMapping("/version")
  @ResponseBody
  public BuildVersion getVersion() {
    return buildVersion;
  }
}
