package com.anele.tests;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.assertj.core.api.Assertions.assertThat;

// import com.anele.CountryRouters;
import com.anele.endPoints.Routers;
import com.anele.models.Country;
import com.anele.models.Parameters;
import com.anele.requestSpecification.CountriesSpecifications;
import com.anele.utils.BaseCore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;
import org.testng.internal.Parameters;

public class CountriesTest extends BaseCore {

  // Get all available countries across all {seasons} and competitions
  @Test
  public void getAllAvailableCountries() {
    given()
      .spec(CountriesSpecifications.getAllCountries())
      .when()
      .get(Routers.GET_COUNTIRIES)
      .then()
      .statusCode(200);
  }

  // Get all available countries from one id {id}
  @Test
  public void getASpecificCountryUsingId() throws JsonMappingException, JsonProcessingException {
    Map<String, Object> idParams = new HashMap<>();
    idParams.put("id", "1");

    ResponseBody httpResponse = given().spec(CountriesSpecifications.countryIdParams(idParams)).when().get(Routers.GET_COUNTIRIES).getBody();

    // Deserialize the JSON response into a Country object
    ObjectMapper objectMapper = new ObjectMapper();

    Country country = objectMapper.readValue(httpResponse.asString(), Country.class);

    System.out.println(country);

  }

  private Country deserilizeCountryResponse(Response httpResponse){

    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.readValue(null, null)

  }

}
