package org.example.controller;


import org.example.api.model.Product;
import org.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.api.controller.ProductApi;
import java.util.List;

@RestController
public class Controller implements ProductApi {

    @Autowired private ProductService service;

    @Override
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = service.getAllProducts();
        return ResponseEntity.ok(products);
    }

}
