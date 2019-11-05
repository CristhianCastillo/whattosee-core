package ml.whattosee.repository;

import ml.whattosee.model.PersonEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonTypeRepository extends CrudRepository<PersonEntity, Long> {
}
