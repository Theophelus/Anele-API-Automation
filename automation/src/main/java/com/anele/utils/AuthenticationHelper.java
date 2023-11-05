package com.anele.utils;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import java.util.HashMap;
import java.util.Map;

public class AuthenticationHelper {

  public static RequestSpecification setRequestSpecification() {
    // Define constants for headers and content type
    final String RAPID_API_KEY = "86ba85eabba0192e41334955c0f23bb5";
    final String RAPID_API_HOST = "v1.basketball.api-sports.io";
    final String CONTENT_TYPE = "application/json";

    // Validate the headers
    if (RAPID_API_KEY == null || RAPID_API_HOST == null) {
      throw new IllegalArgumentException("API key or host is not provided.");
    }

    // Create the header map
    Map<String, String> header = new HashMap<>();
    header.put("x-rapidapi-key", RAPID_API_KEY);
    header.put("x-rapidapi-host", RAPID_API_HOST);

    // Create the RequestSpecification
    RequestSpecification httpRequest = RestAssured
      .given()
      .headers(header)
      .contentType(CONTENT_TYPE);

    return httpRequest;
  }
}
