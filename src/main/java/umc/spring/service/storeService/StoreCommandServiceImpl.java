package umc.spring.service.storeService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.TempHandler;
import umc.spring.converter.StoreCategoryConverter;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.FoodCategory;
import umc.spring.domain.Store;
import umc.spring.domain.mapping.StoreCategory;
import umc.spring.repository.FoodCategoryRepository;
import umc.spring.repository.storeRepository.StoreRepository;
import umc.spring.web.dto.StoreRequestDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Store addStoreWithLocation(StoreRequestDTO.addWithLocationDTO request) {
        Store newStore = StoreConverter.toStore(request);
        List<FoodCategory> foodCategoryList = request.getStoreCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(
                            () -> new TempHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).toList();

        List<StoreCategory> storeCategoryList = StoreCategoryConverter.toStoreCategoryList(foodCategoryList);
        storeCategoryList.forEach(storeCategory -> storeCategory.setStore(newStore));

        return storeRepository.save(newStore);
    }

    @Override
    public boolean isStoreExist(Long storeId) {
        return storeRepository.existsById(storeId);
    }
}
