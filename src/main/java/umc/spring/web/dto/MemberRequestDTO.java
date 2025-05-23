package umc.spring.web.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.spring.domain.enums.Gender;
import umc.spring.validation.annotation.ExistCategories;

import java.util.List;

public class MemberRequestDTO {

    @Getter
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
        String email;
        @Size(min = 10, max = 11)
        String phoneNumber;

        @ExistCategories
        List<Long> preferCategory;
    }
}
