package umc.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class MissionRequestDTO {

    @Getter
    public static class addIntoStoreDTO{

        @NotNull
        String missionSpec;
        @NotNull
        Integer point;
        @NotNull
        Integer requiredPrice;
    }
}
