package umc.spring.service;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.TempHandler;
import umc.spring.config.security.jwt.JwtTokenProvider;
import umc.spring.converter.MemberConverter;
import umc.spring.domain.Member;
import umc.spring.repository.MemberRepository;
import umc.spring.web.dto.MemberResponseDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService{

    private final JwtTokenProvider jwtTokenProvider;
    private final MemberRepository memberRepository;

    @Override
    public MemberResponseDTO.MemberInfoDTO getMemberInfo(HttpServletRequest request) {
        Authentication authentication = jwtTokenProvider.extractAuthentication(request);
        String username = authentication.getName();

        Member member = memberRepository.findByUsername(username)
                .orElseThrow(() -> new TempHandler(ErrorStatus.MEMBER_NOT_FOUND));
        return MemberConverter.toMemberInfoDTO(member);
    }
}
