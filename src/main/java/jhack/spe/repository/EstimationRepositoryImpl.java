package jhack.spe.repository;

import jhack.spe.entities.EstimationEntity;
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
public class EstimationRepositoryImpl implements EstimationRepository {

    @Resource(name = "sessionFactory")
    @Getter
    @Setter
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public List<EstimationEntity> findAllByTeamMemberId(Integer teamMemberId) {

        Session session = sessionFactory.getCurrentSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<EstimationEntity> query
                = builder.createQuery(EstimationEntity.class);

        Root<EstimationEntity> employee
                = query.from(EstimationEntity.class);

        query.where(builder.equal(employee.get("teamMemberId"), teamMemberId));

        query.select(employee);

        return session.createQuery(query).list();

    }

    @Transactional
    @Override
    public EstimationEntity save(EstimationEntity estimationEntity) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(estimationEntity);
        return estimationEntity;
    }

    @Transactional
    @Override
    public EstimationEntity findById(Integer id) {

        Session session = sessionFactory.getCurrentSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<EstimationEntity> query
                = builder.createQuery(EstimationEntity.class);

        Root<EstimationEntity> employee
                = query.from(EstimationEntity.class);

        query.where(builder.equal(employee.get("id"), id));

        query.select(employee);

        List<EstimationEntity> estimationEntities = session.createQuery(query).list();

        return estimationEntities.isEmpty() ? null : estimationEntities.get(0);

    }

}
