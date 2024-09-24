package com.ms.ecom.order.service;

import com.ms.ecom.order.client.InventoryClient;
import com.ms.ecom.order.dto.OrderRequest;
import com.ms.ecom.order.model.Order;
import com.ms.ecom.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    public void placeOrder(OrderRequest orderRequest) {
        //Check if item is in stock
        var isProductInStock = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());

        if (isProductInStock) {
            //Map order request to order object
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setPrice(orderRequest.price());
            order.setSkuCode(orderRequest.skuCode());
            order.setQuantity(orderRequest.quantity());

            // save order to OrderRepository
            orderRepository.save(order);
        } else {
            throw new RuntimeException("Product  with skuCode " + orderRequest.skuCode() + " is out of stock");
        }

    }
}
