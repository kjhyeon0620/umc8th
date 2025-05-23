package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.validation.annotation.ExistCategories;

import java.util.List;

public class StoreRequestDTO {

    @Getter
    public static class addWithLocationDTO{
        @NotBlank
        String name;
        @NotNull
        String location;
        @NotNull
        String info;
        @ExistCategories
        List<Long> storeCategory;
    }
}
