package com.anele.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SeasonModel {

  private ArrayList<Object> errors;

  private int results;

  private ArrayList<Object> response;

  @JsonProperty("errors")
  public ArrayList<Object> getErrors() {
    return this.errors;
  }

  @JsonProperty("results")
  public int getResults() {
    return this.results;
  }

  @JsonProperty("response")
  public ArrayList<Object> getResponse() {
    return this.response;
  }
}
