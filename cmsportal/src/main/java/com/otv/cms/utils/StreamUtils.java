package com.otv.cms.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public final class StreamUtils {
  private StreamUtils() {
  }

  public static final String getStringFromInputStream(InputStream input) {
    StringBuilder stringBuilder = new StringBuilder();
    try {
      BufferedReader reader = new BufferedReader(new InputStreamReader(input));
      while (true) {
        String line = reader.readLine();
        if (line == null)
          break;
        stringBuilder.append(line);
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return stringBuilder.toString();
  }
}
