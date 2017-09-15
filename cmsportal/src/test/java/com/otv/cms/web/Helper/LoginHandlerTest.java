package com.otv.cms.web.Helper;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

import com.otv.cms.web.pojo.Response.SuccessResponseEntity;

public class LoginHandlerTest {

  @Test
  public void testDBConnection_executeLogin() {
    ConcurrentHashMap<String, String> loginMap = new ConcurrentHashMap<String, String>();
    loginMap.put("user_id", "2000");
    loginMap.put("user_secret", "johndoe");
    SuccessResponseEntity successResponseEntity = LoginHandler.executeLogin(loginMap);
    assertThat(successResponseEntity.getResponseContent()).isEqualTo("{'authStatus':'success'}");
  }
}
