package com.ms.ecom.inventory.service;

import com.ms.ecom.inventory.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository  inventoryRepository;

    public boolean isInStock(String skuCode, Integer quantity) {
        //Find an inventory for given skucode where quanity >= 0
        return inventoryRepository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode, quantity);
    }
}
