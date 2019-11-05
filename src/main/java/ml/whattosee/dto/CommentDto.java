package ml.whattosee.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentDto {

    private Long id;
    private String description;
    private Date creation;
    private UserDto userEntity;
    private MovieDto movieEntity;

    public CommentDto() {
    }

    public CommentDto(Long id, String description, Date creation, UserDto userEntity, MovieDto movieEntity) {
        this.id = id;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public UserDto getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserDto userEntity) {
        this.userEntity = userEntity;
    }

    public MovieDto getMovieEntity() {
        return movieEntity;
    }

    public void setMovieEntity(MovieDto movieEntity) {
        this.movieEntity = movieEntity;
    }
}
