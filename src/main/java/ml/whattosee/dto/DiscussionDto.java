package ml.whattosee.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DiscussionDto {

    private Long id;
    private String name;
    private Date creation;
    private UserDto userEntity;
    private MovieDto movieEntity;

    public DiscussionDto() {

    }

    public DiscussionDto(Long id, String name, Date creation, UserDto userEntity, MovieDto movieEntity) {
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
