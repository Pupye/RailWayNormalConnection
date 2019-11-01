
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
    "destinationStationId",
    "arrivalStationId",
    "date"
})
public class SearchGet {

    @JsonProperty("destinationStationId")
    private Integer destinationStationId;
    @JsonProperty("arrivalStationId")
    private Integer arrivalStationId;
    @JsonProperty("date")
    private String date;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public SearchGet() {
    }

    /**
     * 
     * @param date
     * @param arrivalStationId
     * @param destinationStationId
     */
    public SearchGet(Integer destinationStationId, Integer arrivalStationId, String date) {
        super();
        this.destinationStationId = destinationStationId;
        this.arrivalStationId = arrivalStationId;
        this.date = date;
    }

    @JsonProperty("destinationStationId")
    public Integer getDestinationStationId() {
        return destinationStationId;
    }

    @JsonProperty("destinationStationId")
    public void setDestinationStationId(Integer destinationStationId) {
        this.destinationStationId = destinationStationId;
    }

    @JsonProperty("arrivalStationId")
    public Integer getArrivalStationId() {
        return arrivalStationId;
    }

    @JsonProperty("arrivalStationId")
    public void setArrivalStationId(Integer arrivalStationId) {
        this.arrivalStationId = arrivalStationId;
    }

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
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
