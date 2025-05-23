package umc.spring.converter;

import umc.spring.domain.Review;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {

    public static ReviewResponseDTO.addResultDTO toAddResultDTO(Review review) {
        return ReviewResponseDTO.addResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.addDTO request) {
        return Review.builder()
                .content(request.getContent())
                .rating(request.getRating())
                .build();
    }
}
