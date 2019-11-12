package ml.whattosee.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ml.whattosee.model.DiscussionEntity;

@Repository
public interface DiscussionRepository extends CrudRepository<DiscussionEntity, Long> {

	DiscussionEntity findByid(Long id);
}
