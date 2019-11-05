package ml.whattosee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movie")
public class MovieEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "name")
    private String name;
    @Column(nullable = false, name = "score")
    private Long score;
    @Column(nullable = false, name = "score_counter")
    private Long scoreCounter;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "movie_actor", joinColumns = @JoinColumn(name = "id_movie"), inverseJoinColumns = @JoinColumn(name = "id_actor"))
    private List<PersonEntity> actorList;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "movie_productor", joinColumns = @JoinColumn(name = "id_movie"), inverseJoinColumns = @JoinColumn(name = "id_productor"))
    private List<PersonEntity> productorList;
    @ManyToOne
    @JoinColumn(nullable = false, name = "classification_id")
    private ClassificationEntity classificationEntity;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "movie_gender", joinColumns = @JoinColumn(name = "id_movie"), inverseJoinColumns = @JoinColumn(name = "id_gender"))
    private List<GenderEntity> genderList;

    public MovieEntity() {

    }

    public MovieEntity(Long id, String name, Long score, Long scoreCounter, List<PersonEntity> actorList, List<PersonEntity> productorList, ClassificationEntity classificationEntity, List<GenderEntity> genderList) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.scoreCounter = scoreCounter;
        this.actorList = actorList;
        this.productorList = productorList;
        this.classificationEntity = classificationEntity;
        this.genderList = genderList;
    }


    public MovieEntity(Long id, String name, Long score, Long scoreCounter, List<PersonEntity> actorList, List<PersonEntity> productorList, ClassificationEntity classificationEntity) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.scoreCounter = scoreCounter;
        this.actorList = actorList;
        this.productorList = productorList;
        this.classificationEntity = classificationEntity;
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

    public List<PersonEntity> getActorList() {
        return actorList;
    }

    public void setActorList(List<PersonEntity> actorList) {
        this.actorList = actorList;
    }

    public List<PersonEntity> getProductorList() {
        return productorList;
    }

    public void setProductorList(List<PersonEntity> productorList) {
        this.productorList = productorList;
    }

    public ClassificationEntity getClassificationEntity() {
        return classificationEntity;
    }

    public void setClassificationEntity(ClassificationEntity classificationEntity) {
        this.classificationEntity = classificationEntity;
    }

    public List<GenderEntity> getGenderList() {
        if (genderList != null) {
            List<GenderEntity> result = new ArrayList<>();
            for (GenderEntity genderEntity : genderList) {
                result.add(new GenderEntity(genderEntity.getId(), genderEntity.getName(), genderEntity.getStatus()));
            }
            return result;
        } else
            return null;
    }

    public void setGenderList(List<GenderEntity> genderList) {
        this.genderList = genderList;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public Long getScoreCounter() {
        return scoreCounter;
    }

    public void setScoreCounter(Long scoreCounter) {
        this.scoreCounter = scoreCounter;
    }
}
