
package com.fClientStudents.model;

import java.util.Date;
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
    "name",
    "state",
    "dateCreation",
    "dateMerge",
    "dateRemoved"
})
public class SubjectResponse {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("state")
    private Boolean state;
    @JsonProperty("dateCreation")
    private Date dateCreation;
    @JsonProperty("dateMerge")
    private Date dateMerge;
    @JsonProperty("dateRemoved")
    private Date dateRemoved;
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

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("state")
    public Boolean getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(Boolean state) {
        this.state = state;
    }

    @JsonProperty("dateCreation")
    public Date getDateCreation() {
        return dateCreation;
    }

    @JsonProperty("dateCreation")
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    @JsonProperty("dateMerge")
    public Date getDateMerge() {
        return dateMerge;
    }

    @JsonProperty("dateMerge")
    public void setDateMerge(Date dateMerge) {
        this.dateMerge = dateMerge;
    }

    @JsonProperty("dateRemoved")
    public Date getDateRemoved() {
        return dateRemoved;
    }

    @JsonProperty("dateRemoved")
    public void setDateRemoved(Date dateRemoved) {
        this.dateRemoved = dateRemoved;
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
