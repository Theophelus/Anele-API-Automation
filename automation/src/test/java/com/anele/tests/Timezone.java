package com.anele.tests;

import com.anele.endPoints.Routers;
import com.anele.models.Timezones;
import com.anele.utils.BaseCore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Timezone extends BaseCore {

  @Test
  public void getAllTimezones()
    throws JsonMappingException, JsonProcessingException {
    Response response = requestSpec
      .given()
      .when()
      .get(Routers.GET_TIMEZONES)
      .then()
      .log()
      .all()
      .assertThat()
      .statusCode(200)
      .extract()
      .response();

    //Define ObjectMapper to convert the json response into a Timezone object
    ObjectMapper objectMapper = new ObjectMapper();

    Timezones timezone = objectMapper.readValue(
      response.getBody().asString(),
      Timezones.class
    );

    //Second solution
    Timezones times = response.getBody().as(Timezones.class);

    // Verify the status code (e.g., 200 for a successful request)
    // Assert.assertEquals(response.getStatusCode();
    // System.out.println(timezone.getResponse());
    System.out.println(times.getResponse());
  }

  /*
  Write a test case that will return all size of the timezones across the continent
  */
  @Test
  public void getTheSizeOfTheTimezones() {
    Response httpresonse = requestSpec
      .given()
      .when()
      .get(Routers.GET_TIMEZONES)
      .then()
      .assertThat()
      .statusCode(200)
      .extract()
      .response();

    //Deserialize the response
    Timezones timezones = httpresonse.getBody().as(Timezones.class);

    System.out.println("Size of the list: " + timezones.getResponse().size());

    Assert.assertTrue(
      timezones.getResponse().size() > 0,
      "Validating if the response body as data"
    );
  }

  /*
  Write a test case to filter countries by continents
  */

  @Test
  public void filterByContinents()
    throws JsonMappingException, JsonProcessingException {
    List<String> continents = Arrays.asList(
      "Africa",
      "America",
      "America/Argentina",
      "America",
      "America/Indiana",
      "America",
      "America/North_Dakota",
      "America",
      "Antarctica",
      "Arctic",
      "Asia",
      "Atlantic",
      "Australia",
      "Europe",
      "Indian",
      "Pacific"
    );

    Response httpResponse = requestSpec
      .given()
      .when()
      .get(Routers.GET_TIMEZONES)
      .then()
      .assertThat()
      .statusCode(200)
      .extract()
      .response();

    //Deserialize the response
    ObjectMapper mapper = new ObjectMapper();

    Timezones timezones = mapper.readValue(
      httpResponse.getBody().asString(),
      Timezones.class
    );

    ArrayList<String> timezones2 = timezones.getResponse();

    for (String timeString : timezones2) {
      String current = subStringMapper(timeString);
      for (String iterable_element : continents) {
        if (current.equals(iterable_element)) {
          Assert.assertTrue(
            current.equals(iterable_element),
            "All Contienents are validated: " + current
          );

          break;
        } else {
          Assert.assertFalse(current.equals(iterable_element));
        }
      }
    }
  }

  /*
  Define a method to remove word from the word slash from the the mapper
  */

  public String subStringMapper(String value) {
    String subValue = value;

    int lastIndeOf = subValue.lastIndexOf('/');

    if (lastIndeOf >= 0) {
      subValue = subValue.substring(0, lastIndeOf);
    }

    return subValue;
  }
}
