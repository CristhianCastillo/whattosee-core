package ml.whattosee.repository;

import ml.whattosee.model.RolEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends CrudRepository<RolEntity, Long> {

    RolEntity findByName(String name);
}
