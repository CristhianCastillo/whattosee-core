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
@Table(name = "discussion")
public class DiscussionEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "name")
    private String name;
    @Column(nullable = false, name = "creation")
    private Date creation;
    @ManyToOne
    @JoinColumn(nullable = false, name = "user_id")
    private UserEntity userEntity;
    @ManyToOne
    @JoinColumn(nullable = false, name = "movie_id")
    private MovieEntity movieEntity;

    public DiscussionEntity() {
    }

    public DiscussionEntity(Long id, String name, Date creation, UserEntity userEntity, MovieEntity movieEntity) {
        this.id = id;
        this.name = name;
        this.creation = creation;
        this.userEntity = userEntity;
        this.movieEntity = movieEntity;
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

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public MovieEntity getMovieEntity() {
        return movieEntity;
    }

    public void setMovieEntity(MovieEntity movieEntity) {
        this.movieEntity = movieEntity;
    }
}
