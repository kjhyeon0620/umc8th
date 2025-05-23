package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.converter.MissionMemberConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MissionMember;
import umc.spring.service.MissionCommandService;
import umc.spring.validation.annotation.ChallengeableMission;
import umc.spring.validation.annotation.ExistStore;
import umc.spring.web.dto.MissionMemberResponseDTO;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping
@Validated
public class MissionRestController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/stores/{storeId}/missions")
    public ApiResponse<MissionResponseDTO.addIntoStoreResultDTO> addMission(
            @RequestBody @Valid MissionRequestDTO.addIntoStoreDTO request,
            @ExistStore @PathVariable Long storeId) {
        Mission mission = missionCommandService.addMissionIntoStore(request, storeId);
        return ApiResponse.onSuccess(MissionConverter.toAddIntoStoreResultDTO(mission));

    }

    @PostMapping("/missions/{missionId}/challengers")
    public ApiResponse<MissionMemberResponseDTO.addChallengersResultDTO> addChallenger(
            @ChallengeableMission @PathVariable Long missionId) {

        Long memberIdWithToken = 1L;
        MissionMember missionMember = missionCommandService.addChallenger(memberIdWithToken, missionId);
        return ApiResponse.onSuccess(MissionMemberConverter.toAddChallengersResultDTO(missionMember));
    }

}
