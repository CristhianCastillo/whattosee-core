package ml.whattosee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "person")
public class PersonEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "name")
    private String name;
    @Column(nullable = true, name = "birth")
    private Date birth;
    @Column(nullable = true, name = "country")
    private String country;
    @ManyToOne
    @JoinColumn(nullable = false, name = "person_type_id")
    private PersonTypeEntity personTypeEntity;

    public PersonEntity() {

    }

    public PersonEntity(Long id, String name, Date birth, String country, PersonTypeEntity personTypeEntity) {
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

    public PersonTypeEntity getPersonTypeEntity() {
        return personTypeEntity;
    }

    public void setPersonTypeEntity(PersonTypeEntity personTypeEntity) {
        this.personTypeEntity = personTypeEntity;
    }
}
