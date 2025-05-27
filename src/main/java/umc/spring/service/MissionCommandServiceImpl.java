package umc.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.TempHandler;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.domain.enums.MissionState;
import umc.spring.domain.mapping.MissionMember;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionMemberRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.storeRepository.StoreRepository;
import umc.spring.web.dto.MissionRequestDTO;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService{

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;
    private final MissionMemberRepository missionMemberRepository;

    @Override
    @Transactional
    public Mission addMissionIntoStore(MissionRequestDTO.addIntoStoreDTO request, Long storeId) {

        Mission newMission = MissionConverter.toMission(request);
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new TempHandler(ErrorStatus.STORE_NOT_FOUND));

        newMission.setStore(store);
        return missionRepository.save(newMission);
    }

    @Transactional
    @Override
    public MissionMember addChallenger(Long memberId, Long missionId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new TempHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new TempHandler(ErrorStatus.MISSION_NOT_FOUND));
        MissionMember newMissionMember = MissionMember.builder()
                .state(MissionState.CHALLENGING)
                .build();
        newMissionMember.setMember(member);
        newMissionMember.setMission(mission);

        return missionMemberRepository.save(newMissionMember);
    }

    @Override
    public Page<Mission> getMissionList(Long storeId, Integer page) {
        Store store = storeRepository.findById(storeId).get();
        return missionRepository.findAllByStore(store, PageRequest.of(page, 10));
    }

    @Override
    public Page<MissionMember> getMissionListWithMember(Long memberId, MissionState missionState, Integer page) {
        return missionMemberRepository.findAllByMemberIdAndState(memberId, missionState, PageRequest.of(page, 10));
    }
}
