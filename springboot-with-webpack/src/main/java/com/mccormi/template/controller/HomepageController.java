package com.mccormi.template.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomepageController {
  
  @RequestMapping("/")
  public ModelAndView home() {
    return new ModelAndView("homepage");
  }
  
  
}
