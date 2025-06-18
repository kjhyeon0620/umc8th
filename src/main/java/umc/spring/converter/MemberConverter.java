package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.enums.Gender;
import umc.spring.web.dto.MemberRequestDTO;
import umc.spring.web.dto.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member) {
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDTO request) {
        Gender gender = switch (request.getGender()) {
            case 1 -> Gender.MALE;
            case 2 -> Gender.FEMALE;
            case 3 -> Gender.NONE;
            default -> null;
        };

        return Member.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .name(request.getName())
                .nickname(request.getNickname())
                .gender(gender)
                .email(request.getEmail())
                .role(request.getRole())
                .phoneNumber(request.getPhoneNumber())
                .birthYear(request.getBirthYear())
                .birthMonth(request.getBirthMonth())
                .birthDay(request.getBirthDay())
                .memberPreferList(new ArrayList<>())
                .build();
    }

    public static MemberResponseDTO.LoginResultDTO toLoginResultDTO(Long id, String accessToken) {
        return MemberResponseDTO.LoginResultDTO.builder()
                .memberId(id)
                .accessToken(accessToken)
                .build();
    }

    public static MemberResponseDTO.MemberInfoDTO toMemberInfoDTO(Member member) {
        return MemberResponseDTO.MemberInfoDTO.builder()
                .name(member.getName())
                .username(member.getUsername())
                .gender(member.getGender().name())
                .build();
    }

}
