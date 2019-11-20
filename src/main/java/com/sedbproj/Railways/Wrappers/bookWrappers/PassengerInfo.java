
package com.sedbproj.Railways.Wrappers.bookWrappers;

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
    "Fname",
    "Lname",
    "PhoneNum",
    "Email",
    "Birthday"
})
public class PassengerInfo {

    @JsonProperty("Fname")
    private String fname;
    @JsonProperty("Lname")
    private String lname;
    @JsonProperty("PhoneNum")
    private String phoneNum;
    @JsonProperty("Email")
    private String email;
    @JsonProperty("Birthday")
    private String birthday;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PassengerInfo() {
    }

    /**
     * 
     * @param birthday
     * @param fname
     * @param lname
     * @param phoneNum
     * @param email
     */
    public PassengerInfo(String fname, String lname, String phoneNum, String email, String birthday) {
        super();
        this.fname = fname;
        this.lname = lname;
        this.phoneNum = phoneNum;
        this.email = email;
        this.birthday = birthday;
    }

    @JsonProperty("Fname")
    public String getFname() {
        return fname;
    }

    @JsonProperty("Fname")
    public void setFname(String fname) {
        this.fname = fname;
    }

    @JsonProperty("Lname")
    public String getLname() {
        return lname;
    }

    @JsonProperty("Lname")
    public void setLname(String lname) {
        this.lname = lname;
    }

    @JsonProperty("PhoneNum")
    public String getPhoneNum() {
        return phoneNum;
    }

    @JsonProperty("PhoneNum")
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @JsonProperty("Email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("Email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("Birthday")
    public String getBirthday() {
        return birthday;
    }

    @JsonProperty("Birthday")
    public void setBirthday(String birthday) {
        this.birthday = birthday;
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
