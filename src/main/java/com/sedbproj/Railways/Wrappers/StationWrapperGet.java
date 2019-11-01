
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
    "StationId",
    "Name",
    "ArrTime",
    "DepTime"
})
public class StationWrapperGet {

    @JsonProperty("StationId")
    private Integer stationId;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("ArrTime")
    private String arrTime;
    @JsonProperty("DepTime")
    private String depTime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public StationWrapperGet() {
    }

    /**
     *
     * @param depTime
     * @param name
     * @param arrTime
     * @param stationId
     */
    public StationWrapperGet(Integer stationId, String name, String arrTime, String depTime) {
        super();
        this.stationId = stationId;
        this.name = name;
        this.arrTime = arrTime;
        this.depTime = depTime;
    }

    @JsonProperty("StationId")
    public Integer getStationId() {
        return stationId;
    }

    @JsonProperty("StationId")
    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("ArrTime")
    public String getArrTime() {
        return arrTime;
    }

    @JsonProperty("ArrTime")
    public void setArrTime(String arrTime) {
        this.arrTime = arrTime;
    }

    @JsonProperty("DepTime")
    public String getDepTime() {
        return depTime;
    }

    @JsonProperty("DepTime")
    public void setDepTime(String depTime) {
        this.depTime = depTime;
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
