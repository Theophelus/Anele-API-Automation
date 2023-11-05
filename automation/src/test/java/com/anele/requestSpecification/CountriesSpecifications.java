package com.anele.requestSpecification;

import com.anele.models.Parameters;
import com.anele.utils.BaseCore;
import io.restassured.builder.RequestSpecBuilder;
// estSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import java.util.HashMap;
import java.util.Map;

public class CountriesSpecifications {

  public CountriesSpecifications() {}

  public static RequestSpecification getAllCountries() {
    return new RequestSpecBuilder().setContentType("application/json").build();
  }

  public static RequestSpecification countryIdParams(
    Map<String, Object> queryParams
  ) {
    return new RequestSpecBuilder()
      .addQueryParams(queryParams)
      .setContentType(ContentType.JSON)
      .build();
  }
}
