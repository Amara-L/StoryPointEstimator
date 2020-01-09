package jhack.spe.repository;

import jhack.spe.entities.UserEntity;

public interface UserRepository {

    UserEntity getUserByLogin(String login);

    UserEntity findById(Integer id);

    UserEntity save(UserEntity userEntity);

}
