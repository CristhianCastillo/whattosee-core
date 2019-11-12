package ml.whattosee.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieDto {

	private Long id;
	private String name;
	private Long score;
	private Long scoreCounter;
	private List<PersonDto> actorList;
	private List<PersonDto> productorList;
	private ClassificationDto classificationEntity;
	private List<GenderDto> genderList;
	private List<CommentDto> commentEntityList;

	public MovieDto() {

	}

	public MovieDto(Long id, String name, Long score, Long scoreCounter, List<PersonDto> actorList,
			List<PersonDto> productorList, ClassificationDto classificationEntity, List<GenderDto> genderList,
			List<CommentDto> commentEntityList) {
		this.id = id;
		this.name = name;
		this.score = score;
		this.scoreCounter = scoreCounter;
		this.actorList = actorList;
		this.productorList = productorList;
		this.classificationEntity = classificationEntity;
		this.genderList = genderList;
		this.commentEntityList = commentEntityList;
	}

	public MovieDto(Long id, String name, Long score, Long scoreCounter, List<PersonDto> actorList,
			List<PersonDto> productorList, ClassificationDto classificationEntity, List<GenderDto> genderList) {
		this.id = id;
		this.name = name;
		this.score = score;
		this.scoreCounter = scoreCounter;
		this.actorList = actorList;
		this.productorList = productorList;
		this.classificationEntity = classificationEntity;
		this.genderList = genderList;
	}

	public MovieDto(Long id, String name, Long score, Long scoreCounter, List<PersonDto> actorList,
			List<PersonDto> productorList, ClassificationDto classificationEntity) {
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

	public List<PersonDto> getActorList() {
		return actorList;
	}

	public void setActorList(List<PersonDto> actorList) {
		this.actorList = actorList;
	}

	public List<PersonDto> getProductorList() {
		return productorList;
	}

	public void setProductorList(List<PersonDto> productorList) {
		this.productorList = productorList;
	}

	public List<CommentDto> getCommentEntityList() {
		return commentEntityList;
	}

	public void setCommentEntityList(List<CommentDto> commentEntityList) {
		this.commentEntityList = commentEntityList;
	}

	public ClassificationDto getClassificationEntity() {
		return classificationEntity;
	}

	public void setClassificationEntity(ClassificationDto classificationEntity) {
		this.classificationEntity = classificationEntity;
	}

	public List<GenderDto> getGenderList() {
		return genderList;
	}

	public void setGenderList(List<GenderDto> genderList) {
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
