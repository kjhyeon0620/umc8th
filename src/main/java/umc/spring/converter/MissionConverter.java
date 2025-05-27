package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.domain.mapping.MissionMember;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;
import java.util.List;

public class MissionConverter {

    public static MissionResponseDTO.AddIntoStoreResultDTO toAddIntoStoreResultDTO(Mission mission) {
        return MissionResponseDTO.AddIntoStoreResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.addIntoStoreDTO request) {
        return Mission.builder()
                .missionSpec(request.getMissionSpec())
                .point(request.getPoint())
                .requiredPrice(request.getRequiredPrice())
                .build();
    }

    public static MissionResponseDTO.MissionPreViewDTO missionPreViewDTO(Mission mission) {
        return MissionResponseDTO.MissionPreViewDTO.builder()
                .missionId(mission.getId())
                .missionSpec(mission.getMissionSpec())
                .point(mission.getPoint())
                .requiredPrice(mission.getRequiredPrice())
                .createdAt(mission.getCreatedAt())
                .build();
    }

    public static MissionResponseDTO.MissionWithMemberDTO missionWithMemberDTO(MissionMember missionMember) {
        Mission mission = missionMember.getMission();
        Store store = mission.getStore();
        return MissionResponseDTO.MissionWithMemberDTO.builder()
                .missionId(mission.getId())
                .missionSpec(mission.getMissionSpec())
                .point(mission.getPoint())
                .requiredPrice(mission.getRequiredPrice())
                .storeId(store.getId())
                .storeName(store.getName())
                .createdAt(mission.getCreatedAt())
                .build();
    }
    public static MissionResponseDTO.MissionListDTO<MissionResponseDTO.MissionPreViewDTO> missionPreViewListDTO(Page<Mission> missionList) {
        List<MissionResponseDTO.MissionPreViewDTO> missionPreViewDTOList = missionList.stream()
                .map(MissionConverter::missionPreViewDTO).toList();

        return MissionResponseDTO.MissionListDTO.<MissionResponseDTO.MissionPreViewDTO>builder()
                .missionList(missionPreViewDTOList)
                .isFirst(missionList.isFirst())
                .isLast(missionList.isLast())
                .totalPage(missionList.getTotalPages())
                .listSize(missionPreViewDTOList.size())
                .totalElements(missionList.getTotalElements())
                .build();
    }

    public static MissionResponseDTO.MissionListDTO<MissionResponseDTO.MissionWithMemberDTO> missionWithMemberListDTO(Page<MissionMember> missionList) {
        List<MissionResponseDTO.MissionWithMemberDTO> missionPreViewDTOList = missionList.stream()
                .map(MissionConverter::missionWithMemberDTO).toList();

        return MissionResponseDTO.MissionListDTO.<MissionResponseDTO.MissionWithMemberDTO>builder()
                .missionList(missionPreViewDTOList)
                .isFirst(missionList.isFirst())
                .isLast(missionList.isLast())
                .totalPage(missionList.getTotalPages())
                .listSize(missionPreViewDTOList.size())
                .totalElements(missionList.getTotalElements())
                .build();
    }
}
