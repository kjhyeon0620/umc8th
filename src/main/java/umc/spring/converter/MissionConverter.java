package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;

public class MissionConverter {

    public static MissionResponseDTO.addIntoStoreResultDTO toAddIntoStoreResultDTO(Mission mission) {
        return MissionResponseDTO.addIntoStoreResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.addIntoStoreDTO request) {
        return Mission.builder()
                .mission_spec(request.getMissionSpec())
                .point(request.getPoint())
                .requiredPrice(request.getRequiredPrice())
                .build();
    }
}
