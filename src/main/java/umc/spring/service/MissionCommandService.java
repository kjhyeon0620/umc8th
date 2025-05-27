package umc.spring.service;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionState;
import umc.spring.domain.mapping.MissionMember;
import umc.spring.validation.annotation.ExistStore;
import umc.spring.web.dto.MissionRequestDTO;

public interface MissionCommandService {

    Mission addMissionIntoStore(MissionRequestDTO.addIntoStoreDTO request, Long storeId);

    MissionMember addChallenger(Long memberId, Long missionId);

    Page<Mission> getMissionList(Long storeId, Integer page);

    Page<MissionMember> getMissionListWithMember(Long memberId, MissionState missionState, Integer page);
}
