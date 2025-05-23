package umc.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.enums.MissionState;
import umc.spring.repository.MissionMemberRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionMemberCommandServiceImpl implements MissionMemberCommandService{

    private final MissionMemberRepository missionMemberRepository;

    @Override
    public boolean isMissionReadyForChallenge(Long memberId, Long missionId) {
        return missionMemberRepository.findByMemberIdAndMissionId(memberId, missionId)
                .map(missionMember -> missionMember.getState() == MissionState.READY)
                .orElse(true);
    }
}
