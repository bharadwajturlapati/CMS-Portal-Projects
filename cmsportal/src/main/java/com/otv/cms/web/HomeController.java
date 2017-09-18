package com.otv.cms.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.otv.cms.utils.Base64EncodeDecodeUtils;

@Controller
@RequestMapping("/home")
public class HomeController {
  @RequestMapping(method = RequestMethod.GET)
  public String intoHomeAfterLogin(ModelMap modelMap, @RequestParam("who") String userHashCode) {
    modelMap.put("userid", Base64EncodeDecodeUtils.decodeString(userHashCode));
    return "home";
  }
}
