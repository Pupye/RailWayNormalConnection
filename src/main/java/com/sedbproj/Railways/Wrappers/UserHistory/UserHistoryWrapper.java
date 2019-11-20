package com.sedbproj.Railways.Wrappers.UserHistory;

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
        "trainId",
        "routeId",
        "depTime",
        "ArrTime",
        "arrivalStation",
        "arrivalStationCity",
        "destinationStation",
        "destinationStationCity",
        "passangers"
})

public class UserHistoryWrapper {
    @JsonProperty("trainId")
    private Integer trainId;
    @JsonProperty("routeId")
    private Integer routeId;
    @JsonProperty("depTime")
    private String depTime;
    @JsonProperty("ArrTime")
    private String arrTime;
    @JsonProperty("arrivalStation")
    private String arrivalStation;
    @JsonProperty("arrivalStationCity")
    private String arrivalStationCity;
    @JsonProperty("destinationStation")
    private String destinationStation;
    @JsonProperty("destinationStationCity")
    private String destinationStationCity;
    @JsonProperty("passangers")
    private List<PassengerHistoryWrapper> passangers = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public UserHistoryWrapper() {
    }

    /**
     *
     * @param trainId
     * @param routeId
     * @param depTime
     * @param destinationStationCity
     * @param passangers
     * @param destinationStation
     * @param arrTime
     * @param arrivalStation
     * @param arrivalStationCity
     */
    public UserHistoryWrapper(Integer trainId, Integer routeId, String depTime, String arrTime, String arrivalStation, String arrivalStationCity, String destinationStation, String destinationStationCity, List<PassengerHistoryWrapper> passangers) {
        super();
        this.trainId = trainId;
        this.routeId = routeId;
        this.depTime = depTime;
        this.arrTime = arrTime;
        this.arrivalStation = arrivalStation;
        this.arrivalStationCity = arrivalStationCity;
        this.destinationStation = destinationStation;
        this.destinationStationCity = destinationStationCity;
        this.passangers = passangers;
    }

    @JsonProperty("trainId")
    public Integer getTrainId() {
        return trainId;
    }

    @JsonProperty("trainId")
    public void setTrainId(Integer trainId) {
        this.trainId = trainId;
    }

    @JsonProperty("routeId")
    public Integer getRouteId() {
        return routeId;
    }

    @JsonProperty("routeId")
    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    @JsonProperty("depTime")
    public String getDepTime() {
        return depTime;
    }

    @JsonProperty("depTime")
    public void setDepTime(String depTime) {
        this.depTime = depTime;
    }

    @JsonProperty("ArrTime")
    public String getArrTime() {
        return arrTime;
    }

    @JsonProperty("ArrTime")
    public void setArrTime(String arrTime) {
        this.arrTime = arrTime;
    }

    @JsonProperty("arrivalStation")
    public String getArrivalStation() {
        return arrivalStation;
    }

    @JsonProperty("arrivalStation")
    public void setArrivalStation(String arrivalStation) {
        this.arrivalStation = arrivalStation;
    }

    @JsonProperty("arrivalStationCity")
    public String getArrivalStationCity() {
        return arrivalStationCity;
    }

    @JsonProperty("arrivalStationCity")
    public void setArrivalStationCity(String arrivalStationCity) {
        this.arrivalStationCity = arrivalStationCity;
    }

    @JsonProperty("destinationStation")
    public String getDestinationStation() {
        return destinationStation;
    }

    @JsonProperty("destinationStation")
    public void setDestinationStation(String destinationStation) {
        this.destinationStation = destinationStation;
    }

    @JsonProperty("destinationStationCity")
    public String getDestinationStationCity() {
        return destinationStationCity;
    }

    @JsonProperty("destinationStationCity")
    public void setDestinationStationCity(String destinationStationCity) {
        this.destinationStationCity = destinationStationCity;
    }

    @JsonProperty("passangers")
    public List<PassengerHistoryWrapper> getPassangers() {
        return passangers;
    }

    @JsonProperty("passangers")
    public void setPassangers(List<PassengerHistoryWrapper> passangers) {
        this.passangers = passangers;
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
