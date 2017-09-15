package com.otv.cms.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.otv.cms.web.pojo.LoginDetails;
import com.otv.cms.web.pojo.Response.AbstractResponseEntity;
import com.otv.cms.web.pojo.Response.SuccessResponseEntity;

@RestController
public class LoginController {

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public ResponseEntity<AbstractResponseEntity> getCheckLogin(
      @RequestBody LoginDetails loginDetails) {
    // the new success response entity must be returned from the method that is
    // calling this.
    return new ResponseEntity<AbstractResponseEntity>(new SuccessResponseEntity(), HttpStatus.OK);
  }
}
