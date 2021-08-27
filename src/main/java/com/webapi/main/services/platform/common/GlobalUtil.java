package com.webapi.main.services.platform.common;

import com.fasterxml.jackson.databind.ObjectMapper;


public class GlobalUtil {

  /**
   * convert object to string format.
   */
  public static String asJsonString(final Object obj) {
    try {
      return new ObjectMapper()
          .writeValueAsString(obj);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * checks argument string contains some text.
   */
  public static boolean containsText(CharSequence str) {
    int strLen = str.length();
    for (int i = 0; i < strLen; i++) {
      if (!Character.isWhitespace(str.charAt(i))) {
        return true;
      }
    }
    return false;
  }

  /**
   * checks format of UUID string value.
   */
  public static boolean isUuid(String uuid) {
    return uuid
        .matches("^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$");
  }
}
