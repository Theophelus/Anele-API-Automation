package com.anele.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

// import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Timezones {

  //   String get;
  private int results;
  private ArrayList<String> response;

  @JsonProperty("response")
  public ArrayList<String> getResponse() {
    return this.response;
  }

  @JsonProperty("results")
  public int getResults() {
    return this.results;
  }

}
