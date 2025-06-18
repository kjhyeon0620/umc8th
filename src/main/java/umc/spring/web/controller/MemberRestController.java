package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberConverter;
import umc.spring.domain.Member;
import umc.spring.service.MemberCommandService;
import umc.spring.service.MemberQueryService;
import umc.spring.web.dto.MemberRequestDTO;
import umc.spring.web.dto.MemberResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;

//    @PostMapping("/join")
//    public String join(
//            @ModelAttribute("memberJoinDTO") MemberRequestDTO.JoinDTO request,
//            BindingResult bindingResult,
//            Model model) {
//        System.out.println("-------request = " + request.getUsername());
//        System.out.println("-------request = " + request.getGender());
//        System.out.println("-------request = " + request.getPassword());
//
//        if (bindingResult.hasErrors()) {
//            //뷰에 데이터 바인딩이 실패할 경우 signup 페이지 유지
//            return "signup";
//        }
//
//        try {
//            memberCommandService.joinMember(request);
//            return "redirect:/login";
//        } catch (Exception e) {
//            model.addAttribute("error", e.getMessage());
//            return "signup";
//        }
//    }
    @PostMapping("/join")
    @Operation(summary = "유저 회원가입 API", description = "유저가 회원가입하는 API입니다.")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(
            @RequestBody @Valid MemberRequestDTO.JoinDTO request) {
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @PostMapping("/login")
    @Operation(summary = "유저 로그인 API", description = "유저가 로그인하는 API입니다.")
    public ApiResponse<MemberResponseDTO.LoginResultDTO> login(
            @RequestBody @Valid MemberRequestDTO.LoginRequestDTO request) {
        return ApiResponse.onSuccess(memberCommandService.loginMember(request));
    }

    @GetMapping("/info")
    @Operation(summary = "유저 내 정보 조회 API - 인증 필요",
            description = "유저가 내 정보를 조회하는 API입니다.",
            security = {@SecurityRequirement(name = "JWT TOKEN")})
    public ApiResponse<MemberResponseDTO.MemberInfoDTO> getMyInfo(HttpServletRequest request) {
        return ApiResponse.onSuccess(memberQueryService.getMemberInfo(request));
    }
}
