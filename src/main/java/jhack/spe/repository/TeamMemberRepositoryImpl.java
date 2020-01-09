package jhack.spe.repository;

import jhack.spe.entities.TeamMemberEntity;
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
public class TeamMemberRepositoryImpl implements TeamMemberRepository {

    @Resource(name = "sessionFactory")
    @Getter
    @Setter
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public List<TeamMemberEntity> findAllBySessionId(Integer sessionId) {

        Session session = sessionFactory.getCurrentSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<TeamMemberEntity> query
                = builder.createQuery(TeamMemberEntity.class);

        Root<TeamMemberEntity> employee
                = query.from(TeamMemberEntity.class);

        query.where(builder.equal(employee.get("sessionId"), sessionId));

        query.select(employee);

        return session.createQuery(query).list();

    }

    @Transactional
    @Override
    public TeamMemberEntity save(TeamMemberEntity teamMemberEntity) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(teamMemberEntity);
        return teamMemberEntity;
    }

    @Transactional
    @Override
    public TeamMemberEntity findById(Integer id) {

        Session session = sessionFactory.getCurrentSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<TeamMemberEntity> query
                = builder.createQuery(TeamMemberEntity.class);

        Root<TeamMemberEntity> employee
                = query.from(TeamMemberEntity.class);

        query.where(builder.equal(employee.get("id"), id));

        query.select(employee);

        List<TeamMemberEntity> teamMemberEntities = session.createQuery(query).list();

        return teamMemberEntities.isEmpty() ? null : teamMemberEntities.get(0);

    }

    @Transactional
    @Override
    public TeamMemberEntity findByUserIdAndSessionId(Integer userId, Integer sessionId) {

        Session session = sessionFactory.getCurrentSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<TeamMemberEntity> query
                = builder.createQuery(TeamMemberEntity.class);

        Root<TeamMemberEntity> employee
                = query.from(TeamMemberEntity.class);

        query.where(builder.and(
                builder.equal(employee.get("userId"), userId),
                builder.equal(employee.get("sessionId"), sessionId)));

        query.select(employee);

        List<TeamMemberEntity> teamMemberEntities = session.createQuery(query).list();

        return teamMemberEntities.isEmpty() ? null : teamMemberEntities.get(0);

    }

}
