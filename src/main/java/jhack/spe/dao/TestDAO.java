package jhack.spe.dao;

import jhack.spe.dao.entities.TestEntity;

/**
 * Description interface
 *
 * @author FirstName S. LastName
 * @version 1.0.0 created 09.11.2019
 */
public interface TestDAO {

    /**
     * Method get user by id.
     * @param id - identifier user
     * @return object user
     */
    TestEntity getUserById(Integer id);

}
