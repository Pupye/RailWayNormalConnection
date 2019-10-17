
package com.sedbproj.Railways.Wrappers;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "depTime",
        "arrTime"
})
public class StationWrapper {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("depTime")
    private String depTime;
    @JsonProperty("arrTime")
    private String arrTime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("depTime")
    public String getDepTime() {
        return depTime;
    }

    @JsonProperty("depTime")
    public void setDepTime(String depTime) {
        this.depTime = depTime;
    }

    @JsonProperty("arrTime")
    public String getArrTime() {
        return arrTime;
    }

    @JsonProperty("arrTime")
    public void setArrTime(String arrTime) {
        this.arrTime = arrTime;
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