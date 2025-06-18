package umc.spring.service;

import jakarta.servlet.http.HttpServletRequest;
import umc.spring.web.dto.MemberResponseDTO;

public interface MemberQueryService {
    MemberResponseDTO.MemberInfoDTO getMemberInfo(HttpServletRequest request);
}
