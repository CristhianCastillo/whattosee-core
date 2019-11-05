package ml.whattosee.repository;

import ml.whattosee.model.ClassificationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassificationRepository extends CrudRepository<ClassificationEntity, Long> {
}
