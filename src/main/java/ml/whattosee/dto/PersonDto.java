package ml.whattosee.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonDto {

    private Long id;
    private String name;
    private Date birth;
    private String country;
    private PersonTypeDto personTypeEntity;

    public PersonDto() {

    }

    public PersonDto(Long id, String name, Date birth, String country, PersonTypeDto personTypeEntity) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.country = country;
        this.personTypeEntity = personTypeEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public PersonTypeDto getPersonTypeEntity() {
        return personTypeEntity;
    }

    public void setPersonTypeEntity(PersonTypeDto personTypeEntity) {
        this.personTypeEntity = personTypeEntity;
    }
}
