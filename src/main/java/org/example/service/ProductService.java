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

    public List<Product> getAllProducts() {
        List<ProductEntity> products = productRepository.findByIsDeletedFalse();

        // Map each Product entity to ProductDTO
        return products.stream()
                .map(product -> modelMapper.map(product, Product.class))
                .collect(Collectors.toList());
    }

}
