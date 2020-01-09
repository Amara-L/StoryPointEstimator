package jhack.spe.repository;

import jhack.spe.entities.UserEntity;
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

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Resource(name = "sessionFactory")
    @Getter
    @Setter
    private SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    public UserEntity getUserByLogin(
            String login) {

        Session session = sessionFactory.getCurrentSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<UserEntity> query
                = builder.createQuery(UserEntity.class);

        Root<UserEntity> employee
                = query.from(UserEntity.class);

        query.where(builder.equal(employee.get("login"), login));

        List<UserEntity> userEntities = session.createQuery(query).list();

        return userEntities.isEmpty() ? null : userEntities.get(0);

    }

    @Transactional
    @Override
    public UserEntity findById(Integer id) {

        Session session = sessionFactory.getCurrentSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<UserEntity> query
                = builder.createQuery(UserEntity.class);

        Root<UserEntity> employee
                = query.from(UserEntity.class);

        query.where(builder.equal(employee.get("id"), id));

        query.select(employee);

        List<UserEntity> userEntities = session.createQuery(query).list();

        return userEntities.isEmpty() ? null : userEntities.get(0);

    }

    @Transactional
    @Override
    public UserEntity save(UserEntity userEntity) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(userEntity);
        return userEntity;
    }

}
