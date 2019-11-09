package jhack.spe.dao;

import jhack.spe.dao.entities.TestEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * DAO object test table.
 *
 * @author FirstName S. LastName
 * @version 1.0.0 created 09.11.2019
 */
@Repository // <--- annotation indicating DAO object
public class TestDAOImp implements TestDAO {

    /**
     * Hibernate session factory to operate with the database session.
     */
    @Resource(name = "sessionFactory")
    @Getter
    @Setter
    private SessionFactory sessionFactory;

    /**
     * Method get user by id.
     * @param id - identifier user
     * @return object user
     */
    @Override
    @Transactional // <--- annotation indicating transactional
    public TestEntity getUserById(Integer id) {

        Session session = sessionFactory.getCurrentSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<TestEntity> query
                = builder.createQuery(TestEntity.class);

        Root<TestEntity> employee
                = query.from(TestEntity.class);

        query.where(builder.equal(employee.get("id"), id));

        query.select(employee);

        List<TestEntity> testEntities =  session.createQuery(query).list();

        return (testEntities.isEmpty()) ? null : testEntities.get(0);

    }

}
