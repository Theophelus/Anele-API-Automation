package com.anele.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.restassured.response.Response;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {

@JsonProperty("get")
private String get;
@JsonProperty("parameters")
private Parameters parameters;
@JsonProperty("errors")
private List<Object> errors;
@JsonProperty("results")
private Integer results;
@JsonProperty("response")
private List<Response> response;
@JsonIgnore
private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

@JsonProperty("get")
public String getGet() {
return get;
}

@JsonProperty("get")
public void setGet(String get) {
this.get = get;
}

@JsonProperty("parameters")
public Parameters getParameters() {
return parameters;
}

@JsonProperty("parameters")
public void setParameters(Parameters parameters) {
this.parameters = parameters;
}

@JsonProperty("errors")
public List<Object> getErrors() {
return errors;
}

@JsonProperty("errors")
public void setErrors(List<Object> errors) {
this.errors = errors;
}

@JsonProperty("results")
public Integer getResults() {
return results;
}

@JsonProperty("results")
public void setResults(Integer results) {
this.results = results;
}

@JsonProperty("response")
public List<Response> getResponse() {
return response;
}

@JsonProperty("response")
public void setResponse(List<Response> response) {
this.response = response;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}
}
