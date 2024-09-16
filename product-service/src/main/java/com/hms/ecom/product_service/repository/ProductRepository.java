package com.hms.ecom.product_service.repository;

import com.hms.ecom.product_service.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
