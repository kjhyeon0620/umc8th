package umc.spring.service;

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;
import umc.spring.validation.annotation.ExistStore;
import umc.spring.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {
    Review addReview(ReviewRequestDTO.addDTO request, Long memberId, Long storeId);

    Page<Review> getReviewList(Long storeId, Integer page);

    Page<Review> getMyReviewList(Long memberId, Long storeId, Integer page);
}
