package ml.whattosee.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DiscussionDto {

	private Long id;
	private String name;
	private Date creation;
	private UserDto userEntity;
	private MovieDto movieEntity;
	private List<CommentDiscussionDto> commentDiscussionEntityList;

	public DiscussionDto() {

	}

	public DiscussionDto(Long id, String name, Date creation, UserDto userEntity, MovieDto movieEntity,
			List<CommentDiscussionDto> commentDiscussionEntityList) {
		this.id = id;
		this.name = name;
		this.creation = creation;
		this.userEntity = userEntity;
		this.movieEntity = movieEntity;
		this.commentDiscussionEntityList = commentDiscussionEntityList;
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

	public List<CommentDiscussionDto> getCommentDiscussionEntityList() {
		return commentDiscussionEntityList;
	}

	public void setCommentDiscussionEntityList(List<CommentDiscussionDto> commentDiscussionEntityList) {
		this.commentDiscussionEntityList = commentDiscussionEntityList;
	}

}
