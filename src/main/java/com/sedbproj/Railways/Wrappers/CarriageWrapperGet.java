
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
    "Type",
    "AvailableSeats"
})
public class CarriageWrapperGet {
    @JsonProperty("Type")
    private String type;
    @JsonProperty("AvailableSeats")
    private Integer availableSeats;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    public CarriageWrapperGet(){

    }

    public CarriageWrapperGet(String type, Integer availableSeats) {
        super();
        this.type = type;
        this.availableSeats = availableSeats;
    }

    @JsonProperty("Type")
    public String getType() {
        return type;
    }

    @JsonProperty("Type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("AvailableSeats")
    public Integer getAvailableSeats() {
        return availableSeats;
    }

    @JsonProperty("AvailableSeats")
    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
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
