package org.example.service;

import org.example.api.model.Product;
import org.example.entity.ProductEntity;
import org.example.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired private ProductRepository productRepository;
    @Autowired private ModelMapper modelMapper;

    // ---------------------------
    // C - Create
    // ---------------------------
    public Product createProduct(Product productDto) {
        ProductEntity entity = modelMapper.map(productDto, ProductEntity.class);
        entity.setProductId(null); // ensure new entity
        entity.setIsDeleted(false);

        ProductEntity saved = productRepository.save(entity);
        return modelMapper.map(saved, Product.class);
    }

    // ---------------------------
    // R - Read
    // ---------------------------
    public List<Product> getAllProducts() {
        List<ProductEntity> products = productRepository.findByIsDeletedFalse();

        return products.stream()
                .map(product -> modelMapper.map(product, Product.class))
                .collect(Collectors.toList());
    }

    public Product getProductById(Long id) {
        ProductEntity entity = productRepository.findByProductIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        return modelMapper.map(entity, Product.class);
    }

    // ---------------------------
    // U - Update
    // ---------------------------
    public Product updateProduct(Long id, Product updatedProductDto) {
        ProductEntity existing = productRepository.findByProductIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // Map incoming data onto entity
        modelMapper.map(updatedProductDto, existing);

        ProductEntity updated = productRepository.save(existing);
        return modelMapper.map(updated, Product.class);
    }

    // ---------------------------
    // D - Delete (Soft Delete)
    // ---------------------------
    public void deleteProduct(Long id) {
        ProductEntity existing = productRepository.findByProductIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        existing.setIsDeleted(true);
        productRepository.save(existing);
    }
}
