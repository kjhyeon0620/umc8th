package umc.spring.converter;

import umc.spring.domain.mapping.MissionMember;
import umc.spring.web.dto.MissionMemberResponseDTO;

import java.time.LocalDateTime;

public class MissionMemberConverter {

    public static MissionMemberResponseDTO.addChallengersResultDTO toAddChallengersResultDTO(
            MissionMember missionMember) {
        return MissionMemberResponseDTO.addChallengersResultDTO.builder()
                .missionMemberId(missionMember.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
