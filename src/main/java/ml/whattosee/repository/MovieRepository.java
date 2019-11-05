package ml.whattosee.repository;

import ml.whattosee.model.MovieEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends CrudRepository<MovieEntity, Long> {

    List<MovieEntity> findByNameContaining(String name);
}
