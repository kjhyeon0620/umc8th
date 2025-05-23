package umc.spring.service;

import java.util.List;

public interface FoodCategoryCommandService {
    boolean areCategoriesValid(List<Long> categoryIdList);
}
