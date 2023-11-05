package com.anele.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseCore {

  protected static RequestSpecification requestSpec;

  @BeforeClass
  public void setup() {
    RestAssured.baseURI = "https://v1.basketball.api-sports.io";
    RestAssured.basePath = "/";
    RestAssured.enableLoggingOfRequestAndResponseIfValidationFails(); // Enable logging
    // Create the request specification using the setRequestSpecification method
    requestSpec = AuthenticationHelper.setRequestSpecification();
  }

  @AfterClass
  public void cleanUp() {
    RestAssured.reset();
  }
}
