package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Store;
import umc.spring.service.storeService.StoreCommandService;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    @PostMapping
    public ApiResponse<StoreResponseDTO.addWithLocationResultDTO> add(
            @RequestBody @Valid StoreRequestDTO.addWithLocationDTO request) {
        Store store = storeCommandService.addStoreWithLocation(request);
        return ApiResponse.onSuccess(StoreConverter.toAddWithLocationResultDTO(store));
    }

}
