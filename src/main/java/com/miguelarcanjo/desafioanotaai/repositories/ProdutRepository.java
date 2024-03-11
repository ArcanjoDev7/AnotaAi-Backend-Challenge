package com.miguelarcanjo.desafioanotaai.repositories;

import com.miguelarcanjo.desafioanotaai.domain.category.product.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutRepository extends MongoRepository<Product, String> {
}
