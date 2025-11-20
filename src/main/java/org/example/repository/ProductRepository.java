package org.example.repository;

import org.example.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    List<ProductEntity> findByIsDeletedFalse();

    Optional<ProductEntity> findByProductIdAndIsDeletedFalse(Long productId);

}
