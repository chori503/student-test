
package com.boot.client;

import java.util.Date;
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
    "id",
    "nie",
    "firstName",
    "secondName",
    "surname",
    "secondSurname",
    "dateBirth",
    "state",
    "dateCreation",
    "dateMerge",
    "dateRemoved",
    "noteList"
})
public class ClientPrueba {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("nie")
    private String nie;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("secondName")
    private String secondName;
    @JsonProperty("surname")
    private String surname;
    @JsonProperty("secondSurname")
    private String secondSurname;
    @JsonProperty("dateBirth")
    private Date dateBirth;
    @JsonProperty("state")
    private Boolean state;
    @JsonProperty("dateCreation")
    private Date dateCreation;
    @JsonProperty("dateMerge")
    private String dateMerge;
    @JsonProperty("dateRemoved")
    private Date dateRemoved;
    @JsonProperty("noteList")
    private List<Object> noteList = null;
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

    @JsonProperty("nie")
    public String getNie() {
        return nie;
    }

    @JsonProperty("nie")
    public void setNie(String nie) {
        this.nie = nie;
    }

    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("secondName")
    public String getSecondName() {
        return secondName;
    }

    @JsonProperty("secondName")
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @JsonProperty("surname")
    public String getSurname() {
        return surname;
    }

    @JsonProperty("surname")
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @JsonProperty("secondSurname")
    public String getSecondSurname() {
        return secondSurname;
    }

    @JsonProperty("secondSurname")
    public void setSecondSurname(String secondSurname) {
        this.secondSurname = secondSurname;
    }

    @JsonProperty("dateBirth")
    public Date getDateBirth() {
        return dateBirth;
    }

    @JsonProperty("dateBirth")
    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
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
    public Object getDateCreation() {
        return dateCreation;
    }

    @JsonProperty("dateCreation")
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    @JsonProperty("dateMerge")
    public String getDateMerge() {
        return dateMerge;
    }

    @JsonProperty("dateMerge")
    public void setDateMerge(String dateMerge) {
        this.dateMerge = dateMerge;
    }

    @JsonProperty("dateRemoved")
    public Object getDateRemoved() {
        return dateRemoved;
    }

    @JsonProperty("dateRemoved")
    public void setDateRemoved(Date dateRemoved) {
        this.dateRemoved = dateRemoved;
    }

    @JsonProperty("noteList")
    public List<Object> getNoteList() {
        return noteList;
    }

    @JsonProperty("noteList")
    public void setNoteList(List<Object> noteList) {
        this.noteList = noteList;
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
