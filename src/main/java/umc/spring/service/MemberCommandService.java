package umc.spring.service;

import org.springframework.stereotype.Service;
import umc.spring.domain.Member;
import umc.spring.web.dto.MemberRequestDTO;
import umc.spring.web.dto.MemberResponseDTO;

public interface MemberCommandService {

    Member joinMember(MemberRequestDTO.JoinDTO request);
    MemberResponseDTO.LoginResultDTO loginMember(MemberRequestDTO.LoginRequestDTO request);
}
