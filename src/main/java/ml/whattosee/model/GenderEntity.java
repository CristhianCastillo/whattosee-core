package ml.whattosee.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "gender")
public class GenderEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, name = "name")
	private String name;
	@Column(nullable = false, name = "status")
	private Boolean status;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "movie_gender", joinColumns = @JoinColumn(name = "id_gender"), inverseJoinColumns = @JoinColumn(name = "id_movie"))
	private List<MovieEntity> movieEntityList;

	public GenderEntity() {
	}

	public GenderEntity(Long id, String name, Boolean status) {
		this.id = id;
		this.name = name;
		this.status = status;
	}

	public GenderEntity(Long id, String name, Boolean status, List<MovieEntity> movieEntityList) {
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

	public List<MovieEntity> getMovieEntityList() {
		if (movieEntityList != null) {
			List<MovieEntity> result = new ArrayList<>();
			for (MovieEntity movieEntity : movieEntityList) {
				result.add(new MovieEntity(movieEntity.getId(), movieEntity.getName(), movieEntity.getScore(),
						movieEntity.getScoreCounter(), movieEntity.getActorList(), movieEntity.getProductorList(),
						movieEntity.getClassificationEntity(), movieEntity.getCommentEntityList()));
			}
			return result;
		} else
			return null;
	}

	public void setMovieEntityList(List<MovieEntity> movieEntityList) {
		this.movieEntityList = movieEntityList;
	}
}
