package jhack.spe.tests.mocks;

import jhack.spe.dao.TestDAO;
import jhack.spe.entities.TestEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Mock-object TestDAO. This object replaces the database connection.
 *
 * @author FirstName S. LastName
 * @version 1.0.0 created 09.11.2019
 */
public class TestDAOMock implements TestDAO {

    /**
     * Emulation database.
     */
    private List<TestEntity> users;

    /**
     * Constructor.
     * Initial data in the list users.
     */
    public TestDAOMock() {
        users = new ArrayList<>();

        TestEntity testEntity1 = new TestEntity();
        testEntity1.setId(0);
        testEntity1.setName("Pierre");
        users.add(testEntity1);

        TestEntity testEntity2 = new TestEntity();
        testEntity2.setId(1);
        testEntity2.setName("Jana");
        users.add(testEntity2);

        TestEntity testEntity3 = new TestEntity();
        testEntity3.setId(2);
        testEntity3.setName("Andreas");
        users.add(testEntity3);

        TestEntity testEntity4 = new TestEntity();
        testEntity4.setId(3);
        testEntity4.setName("Nikolai");
        users.add(testEntity4);

        TestEntity testEntity5 = new TestEntity();
        testEntity5.setId(4);
        testEntity5.setName("Angelina");
        users.add(testEntity5);
    }

    /**
     * Method get user by id.
     *
     * @param id - identifier user
     * @return object user
     */
    @Override
    public TestEntity getUserById(Integer id) {

        return users.stream().filter(
                p -> (p.getId() == (id)))
                .findFirst().orElse(null);
    }

}
