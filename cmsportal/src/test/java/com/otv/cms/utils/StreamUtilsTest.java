package com.otv.cms.utils;

import static org.fest.assertions.api.Assertions.assertThat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.junit.Test;

public class StreamUtilsTest {

  @Test
  public void testGetStringFromInputStream() throws FileNotFoundException {
    InputStream inputStream = new FileInputStream("testfiles/streamUtilsTest.txt");
    String fromStream = StreamUtils.getStringFromInputStream(inputStream);
    assertThat(fromStream).isEqualTo("12345678");
  }
}
