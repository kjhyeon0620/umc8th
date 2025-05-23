package umc.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.repository.FoodCategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FoodCategoryCommandServiceImpl implements FoodCategoryCommandService {
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    public boolean areCategoriesValid(List<Long> categoryIdList) {
        return categoryIdList.stream().allMatch(foodCategoryRepository::existsById);
    }
}
