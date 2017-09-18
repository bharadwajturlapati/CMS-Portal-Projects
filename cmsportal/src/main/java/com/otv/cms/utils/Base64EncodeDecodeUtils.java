package com.otv.cms.utils;

import java.util.Base64;

// TODO: this class must go into a factory so that this can be used as abstract
// factory pattern design
public final class Base64EncodeDecodeUtils {
  private Base64EncodeDecodeUtils() {

  }

  public static String decodeString(String encodedString) {
    return new String(Base64.getDecoder().decode(encodedString.getBytes()));
  }

  public static String encodeString(String plainString) {
    return Base64.getEncoder().encodeToString(plainString.getBytes());
  }
}
