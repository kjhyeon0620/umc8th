package umc.spring.service;

public interface MissionMemberCommandService {
    boolean isMissionReadyForChallenge(Long memberId, Long missionId);
}
