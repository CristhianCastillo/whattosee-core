package ml.whattosee.repository;

import ml.whattosee.model.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    UserEntity findByUserNameOrEmail(String userName, String email);

    UserEntity findByUserName(String userName);
}
