package com.otv.cms.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * TODO: implement write a properties file to the file system as needed.
 * 
 * @author KH2034
 */
public final class PropertyFileUtils {
  private PropertyFileUtils() {

  }

  /**
   * Used to load a .properties file into java properties and then return for
   * processing Usage: Used to read aws credentials stored in the file system
   * and then make use of the properties to read and pass to the functions.
   * TODO: Enhance this to nio pacakage
   * 
   * @throws IOException
   */
  public static Properties getPropertiesFromFile(String filePath) throws IOException {
    InputStream input = new FileInputStream(filePath);
    Properties properties = new Properties();
    // set the properties value
    properties.load(input);
    return properties;
  }

}
