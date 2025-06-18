package umc.spring.web.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import umc.spring.domain.enums.Gender;
import umc.spring.domain.enums.Role;
import umc.spring.validation.annotation.ExistCategories;

import java.util.List;

public class MemberRequestDTO {

    @Getter
    @Setter
    public static class JoinDTO{
        @NotBlank
        String username;
        @NotNull
        String password;
        @NotNull
        String name;
        @NotNull
        String nickname;
        @NotNull
        Integer gender;
        @NotNull
        Integer birthYear;
        @NotNull
        Integer birthMonth;
        @NotNull
        Integer birthDay;
        @NotNull
        String email;
        @Size(min = 10, max = 11)
        String phoneNumber;
        @NotNull
        Role role;

        @ExistCategories
        List<Long> preferCategory;
    }

    @Getter
    @Setter
    public static class LoginRequestDTO {
        @NotBlank(message = "아이디는 필수입니다.")
        private String username;

        @NotBlank(message = "패스워드는 필수입니다.")
        private String password;
    }
}
