package umc.spring.converter;

import umc.spring.domain.FoodCategory;
import umc.spring.domain.mapping.StoreCategory;

import java.util.List;

public class StoreCategoryConverter {

    public static List<StoreCategory> toStoreCategoryList(List<FoodCategory> foodCategoryList) {
        return foodCategoryList.stream()
                .map(foodCategory ->
                        StoreCategory.builder()
                                .foodCategory(foodCategory)
                                .build()
                ).toList();
    }
}
