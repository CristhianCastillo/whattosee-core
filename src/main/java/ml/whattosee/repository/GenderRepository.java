package ml.whattosee.repository;

import ml.whattosee.model.GenderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderRepository extends CrudRepository<GenderEntity, Long> {

}
