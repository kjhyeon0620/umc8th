package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.service.ReviewCommandService;
import umc.spring.validation.annotation.ExistStore;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping
@Validated
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/stores/{storeId}/reviews")
    public ApiResponse<ReviewResponseDTO.addResultDTO> add(
            @RequestBody @Valid ReviewRequestDTO.addDTO request,
            @ExistStore @PathVariable Long storeId) {
        Long memberIdWithToken = 1L;
        Review review = reviewCommandService.addReview(request, 1L, storeId);
        return ApiResponse.onSuccess(ReviewConverter.toAddResultDTO(review));

    }
}
