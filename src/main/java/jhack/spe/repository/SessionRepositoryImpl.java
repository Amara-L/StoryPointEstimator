package jhack.spe.repository;

import jhack.spe.entities.SessionEntity;
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
public class SessionRepositoryImpl implements SessionRepository {

    @Resource(name = "sessionFactory")
    @Getter
    @Setter
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public List<SessionEntity> findAllByOwnerId(Integer ownerId) {

        Session session = sessionFactory.getCurrentSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<SessionEntity> query
                = builder.createQuery(SessionEntity.class);

        Root<SessionEntity> employee
                = query.from(SessionEntity.class);

        query.where(builder.equal(employee.get("ownerId"), ownerId));

        query.select(employee);

        return session.createQuery(query).list();

    }

    @Transactional
    @Override
    public SessionEntity save(SessionEntity sessionEntity) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(sessionEntity);
        return sessionEntity;
    }

    @Transactional
    @Override
    public SessionEntity findById(Integer id) {

        Session session = sessionFactory.getCurrentSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<SessionEntity> query
                = builder.createQuery(SessionEntity.class);

        Root<SessionEntity> employee
                = query.from(SessionEntity.class);

        query.where(builder.equal(employee.get("id"), id));

        query.select(employee);

        List<SessionEntity> sessionEntities = session.createQuery(query).list();

        return sessionEntities.isEmpty() ? null : sessionEntities.get(0);

    }

}
