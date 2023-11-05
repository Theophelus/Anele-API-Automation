package com.anele.tests;

import com.anele.endPoints.Routers;
import com.anele.models.SeasonModel;
import com.anele.utils.BaseCore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seasons extends BaseCore {

  @Test
  public void getAllSeasons() throws JsonMappingException, JsonProcessingException {
    Response httpResponse = requestSpec
      .given()
      .when()
      .get(Routers.GET_SEASONS)
      .then()
      .assertThat()
      .statusCode(200)
      .extract()
      .response();

    //Deserialise the Json response to Object
    ObjectMapper mapper = new ObjectMapper();
    SeasonModel seasons = mapper.readValue(
      httpResponse.getBody().asString(),
      SeasonModel.class
    );

    Assert.assertEquals(
      seasons.getResults(),
      seasons.getResponse().size(),
      "Validte the actual size of the response"
    );
  }
}
