package org.example.service;

import org.example.api.model.Product;
import org.example.entity.ProductEntity;
import org.example.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductService(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    public List<Product> getAllProducts() {
        List<ProductEntity> products = productRepository.findByIsDeletedFalse();

        // Map each Product entity to ProductDTO
        return products.stream()
                .map(product -> modelMapper.map(product, Product.class))
                .collect(Collectors.toList());

    }
}
