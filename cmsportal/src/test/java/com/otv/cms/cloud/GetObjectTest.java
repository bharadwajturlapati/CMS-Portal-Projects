package com.otv.cms.cloud;

import static org.fest.assertions.api.Assertions.assertThat;

import java.io.IOException;
import java.util.Properties;

import org.junit.Ignore;
import org.junit.Test;

import com.otv.cms.exception.CMSException;
import com.otv.cms.utils.PropertyFileUtils;

public class GetObjectTest {

  /* Ignoring the test case and running this as and when needed. */
  @Ignore
  @Test
  public void testGetObjectFromS3() throws IOException, CMSException {
    Properties properties = PropertyFileUtils
        .getPropertiesFromFile("donotcommit/awscreds.properties");
    String responseFromS3 = GetObject.readFromS3(properties.getProperty("accesskey"),
        properties.getProperty("secretkey"), "testfile.txt",
        "bharadwaj-turlapati-java-client");
    assertThat(responseFromS3).isNotEmpty();
    assertThat(responseFromS3).isEqualTo("hello world");
  }
}
