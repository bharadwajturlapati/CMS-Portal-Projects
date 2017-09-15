package com.otv.cms.web.Helper;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Test;

public class SecurityStandardHelperTest {

  @Test
  public void testDecryptAesEncryptedAsUI() {
    String secret = "MTIzNA==";
    String decryptedText = SecurityStandardHelper.decrypt(secret);
    assertThat(decryptedText).isEqualTo("1234");
  }
}
