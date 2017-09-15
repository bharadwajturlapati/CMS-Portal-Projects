package com.otv.cms.web.Helper;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public final class SecurityStandardHelper {
  private SecurityStandardHelper() {

  }

  public static String decrypt(String strToDecrypt) {
    return new String(Base64.getDecoder().decode(strToDecrypt.getBytes()), StandardCharsets.UTF_8);
  }

}
