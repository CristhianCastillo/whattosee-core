package ml.whattosee.repository;

import ml.whattosee.model.CommentDiscussionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentDiscussionRepository extends CrudRepository<CommentDiscussionEntity, Long> {
}
