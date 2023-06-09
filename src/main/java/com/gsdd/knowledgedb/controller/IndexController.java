package com.gsdd.knowledgedb.controller;

import com.gsdd.knowledgedb.constants.ServiceConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

  @GetMapping(ServiceConstants.U_INDEX)
  public String index(Model model) {
    return ServiceConstants.INDEX;
  }
}
