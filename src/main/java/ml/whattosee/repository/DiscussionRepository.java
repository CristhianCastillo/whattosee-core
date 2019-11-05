package ml.whattosee.repository;

import ml.whattosee.model.DiscussionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscussionRepository extends CrudRepository<DiscussionEntity, Long> {
}
