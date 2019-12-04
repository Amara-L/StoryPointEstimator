package jhack.spe.services;

import jhack.spe.dao.entities.EstimationEntity;
import jhack.spe.dao.entities.SessionEntity;
import jhack.spe.dao.entities.TeamMemberEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Service
public class SessionServiceImp implements SessionService {

    //TODO variable for stub
    SessionEntity sessionEntity;

    //TODO Stub
    /**
     * Getting session by id.
     *
     * @param sessionId id session
     * @return session object
     */
    @Override
    public SessionEntity getSession(Integer sessionId) {

        if ((sessionEntity != null) && (sessionId.equals(sessionEntity.getId()))) return sessionEntity;

        return null;

    }

    //TODO Stub
    /**
     * Method create session.
     *
     * @param storyPointId id story point
     * @param userId       id user creator
     * @return session object
     */
    @Override
    public SessionEntity createSession(Integer storyPointId, Integer userId) {

        sessionEntity = new SessionEntity();
        sessionEntity.setId(0);
        sessionEntity.setOwnerId(userId);
        sessionEntity.setProcess(true);
        sessionEntity.setStoryPointId(storyPointId);
        sessionEntity.setCreated(new Date());
        sessionEntity.setTeamMemberEntities(new ArrayList<>());

        TeamMemberEntity teamMemberEntity = new TeamMemberEntity();
        teamMemberEntity.setUserId(userId);
        teamMemberEntity.setSessionEntity(sessionEntity);
        teamMemberEntity.setEstimationEntities(new ArrayList<>());
        teamMemberEntity.setJoiningDate(new Date());
        teamMemberEntity.setActive(true);
        teamMemberEntity.setId(-1);

        sessionEntity.getTeamMemberEntities().add(teamMemberEntity);

        return sessionEntity;

    }

    //TODO Stub
    /**
     * Close session.
     *
     * @param sessionId session id
     * @return result closed session
     */
    @Override
    public boolean closeSession(Integer sessionId) {

        if ((sessionEntity != null) && (sessionId.equals(sessionEntity.getId()))) {

            sessionEntity.setCloses(new Date());
            sessionEntity.setProcess(false);
            int count = 0;
            int sum = 0;

            for (TeamMemberEntity teamMember : sessionEntity.getTeamMemberEntities()) {

                List<EstimationEntity> estimationEntities = teamMember.getEstimationEntities();
                estimationEntities.sort(Comparator.comparing(EstimationEntity::getCreated).reversed());

                if (!estimationEntities.isEmpty()) {

                    sum += estimationEntities.get(0).getResult();
                    count++;
                }

            }

            int result;
            if (count != 0) {
                result = sum/count;
            } else {
                result = 0;
            }

            sessionEntity.setFinalResult(result);

            return true;

        }

        return false;

    }

    //TODO Stub
    /**
     * Join member to session.
     *
     * @param sessionId session id
     * @param userId    user id
     * @return session object
     */
    @Override
    public SessionEntity joinMember(Integer sessionId, Integer userId) {

        if ((sessionEntity != null) && (sessionId.equals(sessionEntity.getId()))) {

            TeamMemberEntity teamMemberEntity = new TeamMemberEntity();
            teamMemberEntity.setActive(true);
            teamMemberEntity.setEstimationEntities(new ArrayList<>());
            teamMemberEntity.setJoiningDate(new Date());
            teamMemberEntity.setSessionEntity(sessionEntity);
            teamMemberEntity.setUserId(userId);
            sessionEntity.getTeamMemberEntities().add(teamMemberEntity);

            return sessionEntity;

        }

        return null;

    }

    //TODO Stub
    /**
     * Method send message on e-mail with session link
     *
     * @param sessionId session id
     * @param mail      mail user
     * @return session object
     */
    @Override
    public SessionEntity inviteMember(Integer sessionId, String mail) {
        return sessionEntity;
    }

    //TODO Stub
    /**
     * Save result estimate.
     *
     * @param teamMemberId id team member
     * @param result       result estimate
     * @return session object
     */
    @Override
    public SessionEntity saveEstimate(Integer teamMemberId, Integer result) {

        EstimationEntity estimationEntity = new EstimationEntity();
        estimationEntity.setResult(result);
        estimationEntity.setCreated(new Date());

        TeamMemberEntity teamMemberEntity
                = sessionEntity.getTeamMemberEntities()
                .stream().filter( t -> t.getUserId().equals(teamMemberId))
                .findFirst().get();

        estimationEntity.setTeamMemberEntity(teamMemberEntity);

        for (TeamMemberEntity teamMember : sessionEntity.getTeamMemberEntities()) {
            if (teamMember.getUserId().equals(teamMemberId)) {
                teamMember.getEstimationEntities().add(estimationEntity);
                break;
            }
        }

        return sessionEntity;
    }

}
