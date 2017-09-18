package com.otv.cms.web.Helper;

import java.util.concurrent.ConcurrentHashMap;

import com.otv.cms.datasource.ExecuteDBQuery;
import com.otv.cms.utils.Base64EncodeDecodeUtils;
import com.otv.cms.web.pojo.Response.SuccessResponseEntity;

public final class LoginHandler {
  private LoginHandler() {

  }

  private static ConcurrentHashMap<String, String> executeReverseHash(String hash) {
    ConcurrentHashMap<String, String> loginMap = new ConcurrentHashMap<String, String>();

    String reverseCreds = SecurityStandardHelper.decrypt(hash);
    String[] credsAsArray = reverseCreds.split(":");

    loginMap.put("user_id", credsAsArray[0]);
    loginMap.put("user_secret", credsAsArray[1]);

    return loginMap;
  }

  public static SuccessResponseEntity executeLogin(
      ConcurrentHashMap<String, String> loginMap) {
    String sql = "select * from employee where emp_id='" + loginMap.get("user_id")
        + "' and emp_secret='" + loginMap.get("user_secret") + "'";

    return ExecuteDBQuery.executeLogin(sql,
        Base64EncodeDecodeUtils.encodeString(loginMap.get("user_id")));
  }

  public static SuccessResponseEntity handleLogin(String hashedString) {

    ConcurrentHashMap<String, String> loginMap = new ConcurrentHashMap<String, String>();
    loginMap = executeReverseHash(hashedString);
    return executeLogin(loginMap);

  }
}
