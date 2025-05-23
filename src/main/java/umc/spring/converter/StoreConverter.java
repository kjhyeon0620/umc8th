package umc.spring.converter;

import umc.spring.domain.Store;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class StoreConverter {

    public static StoreResponseDTO.addWithLocationResultDTO toAddWithLocationResultDTO(Store store) {
        return StoreResponseDTO.addWithLocationResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDTO.addWithLocationDTO request) {
        return Store.builder()
                .name(request.getName())
                .location(request.getLocation())
                .info(request.getInfo())
                .storeCategoryList(new ArrayList<>())
                .build();

    }
}
