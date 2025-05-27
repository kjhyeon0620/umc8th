package umc.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.enums.MissionState;
import umc.spring.domain.mapping.MissionMember;

import java.util.Optional;

public interface MissionMemberRepository extends JpaRepository<MissionMember, Long> {
    Optional<MissionMember> findByMemberIdAndMissionId(Long memberId, Long missionId);

    Page<MissionMember> findAllByMemberIdAndState(Long memberId, MissionState missionState, PageRequest pageRequest);
}
