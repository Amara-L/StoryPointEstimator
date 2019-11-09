package jhack.spe.services;

import jhack.spe.dao.TestDAO;
import jhack.spe.dao.entities.TestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description service
 *
 * @author FirstName S. LastName
 * @version 1.0.0 created 09.11.2019
 */
@Service // <--- annotation indicating service
public class TestServiceImp implements TestService {

    /**
     * DAO object for TestEntity.
     */
    @Autowired // <--- loads the bean. In this case, the object TestDAOImp.
    private TestDAO testDAO;  // <--- initialize the interface (not implementation)

    /**
     * Method getting name user by id.
     * @param id - identifier user
     * @return name user
     */
    @Override
    public String getNameUserById(Integer id) {

        TestEntity testEntity = testDAO.getUserById(id);

        return (testEntity != null) ? testEntity.getName() : "User not found";

    }

}
