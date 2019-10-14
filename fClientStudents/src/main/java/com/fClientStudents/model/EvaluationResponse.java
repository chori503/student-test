
package com.fClientStudents.model;

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
    "description",
    "state",
    "dateCreation",
    "dateMerge",
    "dateRemoved",
    "idSubject"
})
public class EvaluationResponse {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("state")
    private Boolean state;
    @JsonProperty("dateCreation")
    private String dateCreation;
    @JsonProperty("dateMerge")
    private Object dateMerge;
    @JsonProperty("dateRemoved")
    private Object dateRemoved;
    @JsonProperty("idSubject")
    private SubjectResponse idSubject;
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

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
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
    public String getDateCreation() {
        return dateCreation;
    }

    @JsonProperty("dateCreation")
    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    @JsonProperty("dateMerge")
    public Object getDateMerge() {
        return dateMerge;
    }

    @JsonProperty("dateMerge")
    public void setDateMerge(Object dateMerge) {
        this.dateMerge = dateMerge;
    }

    @JsonProperty("dateRemoved")
    public Object getDateRemoved() {
        return dateRemoved;
    }

    @JsonProperty("dateRemoved")
    public void setDateRemoved(Object dateRemoved) {
        this.dateRemoved = dateRemoved;
    }

    @JsonProperty("idSubject")
    public SubjectResponse getIdSubject() {
        return idSubject;
    }

    @JsonProperty("idSubject")
    public void setIdSubject(SubjectResponse idSubject) {
        this.idSubject = idSubject;
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
