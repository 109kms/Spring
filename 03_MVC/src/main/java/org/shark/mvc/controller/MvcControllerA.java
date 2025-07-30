package org.shark.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MvcControllerA {

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String methodA() {
    return "a/list";
  }
  
}
