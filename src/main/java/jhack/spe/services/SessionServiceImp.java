package jhack.spe.services;//package jhack.spe.services;

import jhack.spe.controllers.exception.SendFailedException;
import jhack.spe.controllers.exception.StoryPointEstimatorException;
import jhack.spe.entities.EstimationEntity;
import jhack.spe.entities.SessionEntity;
import jhack.spe.entities.TeamMemberEntity;
import jhack.spe.entities.UserEntity;
import jhack.spe.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SessionServiceImp implements SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private StoryPointRepository storyPointRepository;

    @Autowired
    private EstimationRepository estimationRepository;

    @Autowired
    private TeamMemberRepository teamMemberRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserRepository userRepository;

    /**
     * Getting session by id.
     *
     * @param sessionId id session
     * @return session object
     */
    @Override //TODO возвращать все данные
    public SessionEntity getSession(Integer sessionId) throws StoryPointEstimatorException {

        if (sessionId == null) throw new StoryPointEstimatorException("Session id can't be null");

       SessionEntity sessionEntity = sessionRepository.findById(sessionId);

        if (sessionEntity != null) {

            return sessionEntity;

        } else {

            throw new StoryPointEstimatorException("Session not found");

        }

    }

    /**
     * Method create session.
     *
     * @param storyPointId id story point
     * @param userId       id user creator
     * @return session object
     */
    @Override
    public SessionEntity createSession(Integer storyPointId, Integer userId) throws StoryPointEstimatorException {

        if ((storyPointId == null) && (userId == null))
            throw new StoryPointEstimatorException("Story point id and user id can't be null");

        SessionEntity sessionEntity = new SessionEntity();
        sessionEntity.setOwnerId(userId);
        sessionEntity.setIsProcess(true);
        sessionEntity.setStoryPointId(storyPointId);
        sessionEntity.setCreated(new Date());
        sessionEntity.setTeamMemberEntities(new ArrayList<>());

        sessionEntity = sessionRepository.save(sessionEntity);

        TeamMemberEntity teamMemberEntity = saveTeamMember(userId, sessionEntity.getId());

        teamMemberEntity = teamMemberRepository.save(teamMemberEntity);

        sessionEntity.getTeamMemberEntities().add(teamMemberEntity);

        return sessionEntity;

    }

    /**
     * Close session.
     *
     * @param sessionId session id
     * @return result closed session
     */
    @Override
    public boolean closeSession(Integer sessionId) throws StoryPointEstimatorException {

        if (sessionId == null)
            throw new StoryPointEstimatorException("Session id can't be null");

        SessionEntity sessionEntity = this.getSession(sessionId);

        if (sessionEntity == null) return false;

            sessionEntity.setCloses(new Date());
            sessionEntity.setIsProcess(false);
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

            sessionRepository.save(sessionEntity);

            return true;

    }

    /**
     * Join member to session.
     *
     * @param sessionId session id
     * @param userId    user id
     * @return session object
     */
    @Override
    public SessionEntity joinMember(Integer sessionId, Integer userId) throws StoryPointEstimatorException {

        if (sessionId == null)
            throw new StoryPointEstimatorException("Session id can't be null");

        SessionEntity sessionEntity = this.getSession(sessionId);

        if ((sessionEntity != null) && (sessionId.equals(sessionEntity.getId()))) {

            TeamMemberEntity teamMemberEntity = new TeamMemberEntity();
            teamMemberEntity.setIsActive(true);
            teamMemberEntity.setEstimationEntities(new ArrayList<>());
            teamMemberEntity.setJoiningDate(new Date());
            teamMemberEntity.setSessionId(sessionEntity.getId());
            teamMemberEntity.setUserId(userId);

            teamMemberRepository.save(teamMemberEntity);

            return this.getSession(sessionId);

        }

        return null;

    }

    /**
     * Method send message on e-mail with session link
     *
     * @param sessionId session id
     * @param mail      mail user
     * @return session object
     */
    @Override
    public SessionEntity inviteMember(Integer invitingUserId, Integer sessionId, String mail) throws StoryPointEstimatorException, SendFailedException {

        UserEntity userEntity = userRepository.findById(invitingUserId);

        //TODO добавлять пользователя в БД
        
        StringBuilder text = new StringBuilder("");

        text.append("Dear user! \n \n \n")
                .append("User ")
                .append(userEntity.getName())
                .append(" invited you to rate story point by link ")
                .append("http://localhost:8080/spe/session/")
                .append(sessionId)
                .append("\n \n \n")
                .append("Regards, Development Team SPE");

        emailService.sendSimpleMessage(mail, "Session Invitation for Evaluation", text.toString());

        return this.getSession(sessionId);
    }

    /**
     * Save result estimate.
     *
     * @param userId id team member
     * @param result       result estimate
     * @return session object
     */
    @Override
    public EstimationEntity saveEstimate(Integer sessionId, Integer userId, Integer result) {

        EstimationEntity estimationEntity = new EstimationEntity();
        estimationEntity.setResult(result);
        estimationEntity.setCreated(new Date());

        TeamMemberEntity teamMemberEntity = teamMemberRepository.findByUserIdAndSessionId(userId, sessionId);

        estimationEntity.setTeamMemberId(teamMemberEntity.getId());

        return estimationRepository.save(estimationEntity);

    }

    private TeamMemberEntity saveTeamMember(Integer userId, Integer sessionId) throws StoryPointEstimatorException {

        SessionEntity sessionEntity = getSession(sessionId);

        TeamMemberEntity teamMemberEntity = new TeamMemberEntity();
        teamMemberEntity.setUserId(userId);
        teamMemberEntity.setSessionId(sessionEntity.getId());
        teamMemberEntity.setEstimationEntities(new ArrayList<>());
        teamMemberEntity.setJoiningDate(new Date());
        teamMemberEntity.setIsActive(true);

        return teamMemberRepository.save(teamMemberEntity);

    }

}
