package com.otv.cms.utils;

import static org.fest.assertions.api.Assertions.assertThat;

import java.io.IOException;
import java.util.Properties;

import org.junit.Test;

public class PropertyFileUtilsTest {

  @Test
  public void testGetPropertiesFromFile() throws IOException {
    Properties properties = PropertyFileUtils
        .getPropertiesFromFile("testfiles/simple-key-values.properties");
    assertThat(properties.getProperty("key1")).isEqualTo("value2");
    assertThat(properties.getProperty("key2")).isEqualTo("value3");
    assertThat(properties.getProperty("key3")).isEqualTo("value4");
    assertThat(properties.getProperty("keynull")).isEqualTo("null");
    assertThat(properties.getProperty("%")).isEqualTo("#");
  }
}
