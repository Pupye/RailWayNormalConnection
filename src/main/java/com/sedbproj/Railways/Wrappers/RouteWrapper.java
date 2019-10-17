
package com.sedbproj.Railways.Wrappers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "capacity",
        "train",
        "stations"
})
public class RouteWrapper {

    @JsonProperty("capacity")
    private Integer capacity;
    @JsonProperty("train")
    private Integer train;
    @JsonProperty("stations")
    private List<StationWrapper> stations = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("capacity")
    public Integer getCapacity() {
        return capacity;
    }

    @JsonProperty("capacity")
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @JsonProperty("train")
    public Integer getTrain() {
        return train;
    }

    @JsonProperty("train")
    public void setTrain(Integer train) {
        this.train = train;
    }

    @JsonProperty("stations")
    public List<StationWrapper> getStations() {
        return stations;
    }

    @JsonProperty("stations")
    public void setStations(List<StationWrapper> stations) {
        this.stations = stations;
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