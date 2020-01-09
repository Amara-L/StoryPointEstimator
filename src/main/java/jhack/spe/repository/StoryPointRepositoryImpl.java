package jhack.spe.repository;

import jhack.spe.entities.StoryPointEntity;
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
public class StoryPointRepositoryImpl implements StoryPointRepository {

    @Resource(name = "sessionFactory")
    @Getter
    @Setter
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public StoryPointEntity save(StoryPointEntity storyPointEntity) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(storyPointEntity);
        return storyPointEntity;
    }


    @Transactional
    @Override
    public List<StoryPointEntity> findAllByUserId(Integer userId) {

        Session session = sessionFactory.getCurrentSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<StoryPointEntity> query
                = builder.createQuery(StoryPointEntity.class);

        Root<StoryPointEntity> employee
                = query.from(StoryPointEntity.class);

        query.where(builder.equal(employee.get("userId"), userId));

        query.select(employee);

        return session.createQuery(query).list();

    }

    @Transactional
    @Override
    public StoryPointEntity findById(Integer id) {

        Session session = sessionFactory.getCurrentSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<StoryPointEntity> query
                = builder.createQuery(StoryPointEntity.class);

        Root<StoryPointEntity> employee
                = query.from(StoryPointEntity.class);

        query.where(builder.equal(employee.get("id"), id));

        query.select(employee);

        List<StoryPointEntity> storyPointEntities = session.createQuery(query).list();

        return storyPointEntities.isEmpty() ? null : storyPointEntities.get(0);

    }

}
