package ml.whattosee.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class CommentEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, name = "description")
	private String description;
	@Column(nullable = false, name = "creation")
	private Date creation;
	@ManyToOne
	@JoinColumn(nullable = false, name = "user_id")
	private UserEntity userEntity;
	@ManyToOne
	@JoinColumn(nullable = false, name = "movie_id")
	private MovieEntity movieEntity;

	public CommentEntity() {

	}

	public CommentEntity(Long id, String description, Date creation, UserEntity userEntity, MovieEntity movieEntity) {
		this.id = id;
		this.description = description;
		this.creation = creation;
		this.userEntity = userEntity;
		this.movieEntity = movieEntity;
	}

	public CommentEntity(Long id, String description, Date creation, UserEntity userEntity) {
		this.id = id;
		this.description = description;
		this.creation = creation;
		this.userEntity = userEntity;
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

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public MovieEntity getMovieEntity() {
		if (movieEntity != null) {
			return new MovieEntity(movieEntity.getId(), movieEntity.getName(), movieEntity.getScore(),
					movieEntity.getScoreCounter());
		} else
			return null;
	}

	public void setMovieEntity(MovieEntity movieEntity) {
		this.movieEntity = movieEntity;
	}
}
