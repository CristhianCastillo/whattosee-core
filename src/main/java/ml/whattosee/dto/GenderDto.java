package ml.whattosee.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GenderDto {

    private Long id;
    private String name;
    private Boolean status;
    private List<MovieDto> movieEntityList;

    public GenderDto() {

    }

    public GenderDto(Long id, String name, Boolean status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public GenderDto(Long id, String name, Boolean status, List<MovieDto> movieEntityList) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.movieEntityList = movieEntityList;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<MovieDto> getMovieEntityList() {
        return movieEntityList;
    }

    public void setMovieEntityList(List<MovieDto> movieEntityList) {
        this.movieEntityList = movieEntityList;
    }
}
