
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
    "RouteId",
    "TrainId",
    "stations",
    "carriages"
})
public class RouteWrapperGet {

    @JsonProperty("RouteId")
    private Integer routeId;
    @JsonProperty("TrainId")
    private Integer trainId;
    @JsonProperty("stations")
    private List<StationWrapperGet> stationWrapperGets = null;
    @JsonProperty("carriages")
    private List<CarriageWrapperGet> carriageWrappers = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public RouteWrapperGet() {
    }

    /**
     *
     * @param trainId
     * @param carriages
     * @param routeId
     * @param stations
     */
    public RouteWrapperGet(Integer routeId, Integer trainId, List<StationWrapperGet> stations, List<CarriageWrapperGet> carriages) {
        super();
        this.routeId = routeId;
        this.trainId = trainId;
        this.stationWrapperGets = stations;
        this.carriageWrappers = carriages;
    }

    @JsonProperty("RouteId")
    public Integer getRouteId() {
        return routeId;
    }

    @JsonProperty("RouteId")
    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    @JsonProperty("TrainId")
    public Integer getTrainId() {
        return trainId;
    }

    @JsonProperty("TrainId")
    public void setTrainId(Integer trainId) {
        this.trainId = trainId;
    }

    @JsonProperty("stations")
    public List<StationWrapperGet> getStationWrapperGets() {
        return stationWrapperGets;
    }

    @JsonProperty("stations")
    public void setStationWrapperGets(List<StationWrapperGet> stationWrapperGets) {
        this.stationWrapperGets = stationWrapperGets;
    }

    @JsonProperty("carriages")
    public List<CarriageWrapperGet> getCarriageWrappers() {
        return carriageWrappers;
    }

    @JsonProperty("carriages")
    public void setCarriageWrappers(List<CarriageWrapperGet> carriageWrappers) {
        this.carriageWrappers = carriageWrappers;
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
