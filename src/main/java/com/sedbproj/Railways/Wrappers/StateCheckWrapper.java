package com.sedbproj.Railways.Wrappers;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class StateCheckWrapper {

    @JsonProperty("trainId")
    private Integer trainId;
    @JsonProperty("arrStationName")
    private String arrStationName;
    @JsonProperty("arrCity")
    private String arrCity;
    @JsonProperty("arrivalTime")
    private String arrivalTime;
    @JsonProperty("depStationName")
    private String depStationName;
    @JsonProperty("depCity")
    private String depCity;
    @JsonProperty("depTime")
    private String depTime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public StateCheckWrapper() {
    }

    /**
     *
     * @param trainId
     * @param arrStationName
     * @param arrivalTime
     * @param depTime
     * @param arrCity
     * @param depCity
     * @param depStationName
     */
    public StateCheckWrapper(Integer trainId, String arrStationName, String arrCity, String arrivalTime, String depStationName, String depCity, String depTime) {
        super();
        this.trainId = trainId;
        this.arrStationName = arrStationName;
        this.arrCity = arrCity;
        this.arrivalTime = arrivalTime;
        this.depStationName = depStationName;
        this.depCity = depCity;
        this.depTime = depTime;
    }

    @JsonProperty("trainId")
    public Integer getTrainId() {
        return trainId;
    }

    @JsonProperty("trainId")
    public void setTrainId(Integer trainId) {
        this.trainId = trainId;
    }

    @JsonProperty("arrStationName")
    public String getArrStationName() {
        return arrStationName;
    }

    @JsonProperty("arrStationName")
    public void setArrStationName(String arrStationName) {
        this.arrStationName = arrStationName;
    }

    @JsonProperty("arrCity")
    public String getArrCity() {
        return arrCity;
    }

    @JsonProperty("arrCity")
    public void setArrCity(String arrCity) {
        this.arrCity = arrCity;
    }

    @JsonProperty("arrivalTime")
    public String getArrivalTime() {
        return arrivalTime;
    }

    @JsonProperty("arrivalTime")
    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @JsonProperty("depStationName")
    public String getDepStationName() {
        return depStationName;
    }

    @JsonProperty("depStationName")
    public void setDepStationName(String depStationName) {
        this.depStationName = depStationName;
    }

    @JsonProperty("depCity")
    public String getDepCity() {
        return depCity;
    }

    @JsonProperty("depCity")
    public void setDepCity(String depCity) {
        this.depCity = depCity;
    }

    @JsonProperty("depTime")
    public String getDepTime() {
        return depTime;
    }

    @JsonProperty("depTime")
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
