package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.converter.MissionMemberConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionState;
import umc.spring.domain.mapping.MissionMember;
import umc.spring.service.MissionCommandService;
import umc.spring.validation.annotation.ChallengeableMission;
import umc.spring.validation.annotation.ExistStore;
import umc.spring.validation.annotation.ValidatedPage;
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
    public ApiResponse<MissionResponseDTO.AddIntoStoreResultDTO> addMission(
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

    @GetMapping("/{storeId}/missions")
    @Operation(summary = "특정 가게의 미션 목록 조회 API",
            description = "특정 가게의 미션들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰 모양이 이상함", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!"),
            @Parameter(
                    name = "page",
                    description = "페이지 번호 (1부터 시작)",
                    required = true,
                    example = "1"
            )
    })
    public ApiResponse<MissionResponseDTO.MissionListDTO<MissionResponseDTO.MissionPreViewDTO>> getMissionList(
            @ExistStore @PathVariable Long storeId, @ValidatedPage Integer page) {
        Page<Mission> missionList = missionCommandService.getMissionList(storeId, page);
        return ApiResponse.onSuccess(MissionConverter.missionPreViewListDTO(missionList));
    }

    @GetMapping("/members/missions")
    @Operation(summary = "특정 멤버가 진행중/진행 완료한 미션 목록 조회 API",
            description = "특정 멤버가 진행중/ 진행 완료한 미션 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰 모양이 이상함", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(
                    name = "state",
                    description = "미션 상태 필터입니다. 사용 가능한 값: CHALLENGING(진행중), COMPLETED(완료)",
                    required = true,
                    schema = @Schema(type = "string", allowableValues = {"CHALLENGING", "COMPLETED"})
            ),
            @Parameter(
                    name = "page",
                    description = "페이지 번호 (1부터 시작)",
                    required = true,
                    example = "1"
            )
    })
    public ApiResponse<MissionResponseDTO.MissionListDTO<MissionResponseDTO.MissionWithMemberDTO>> getMissionListWithMember(
            @ValidatedPage Integer page, @RequestParam MissionState state) {
        Long memberIdWithToken = 1L; // 멤버 id 임의로 설정
        Page<MissionMember> missionList = missionCommandService.getMissionListWithMember(memberIdWithToken, state, page);
        return ApiResponse.onSuccess(MissionConverter.missionWithMemberListDTO(missionList));
    }
}
