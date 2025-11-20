package org.example.controller;

import org.example.api.controller.ProductApi;
import org.example.api.model.Product;
import org.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
public class Controller implements ProductApi {

    @Autowired
    private ProductService productService;

    // CREATE
    @Override
    public ResponseEntity<Product> createProduct(Product product) {
        Product created = productService.createProduct(product);

        return ResponseEntity
                .created(URI.create("/product/" + created.getProductId()))
                .body(created);
    }

    // READ ALL
    @Override
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    // READ ONE
    @Override
    public ResponseEntity<Product> getProductById(Long id) {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    // UPDATE
    @Override
    public ResponseEntity<Product> updateProduct(Long id, Product product) {
        Product updated = productService.updateProduct(id, product);
        return ResponseEntity.ok(updated);
    }

    // DELETE
    @Override
    public ResponseEntity<Void> deleteProduct(Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
