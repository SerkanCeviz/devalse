package com.devalse.devalse.controller;

import com.devalse.devalse.model.ProductDto;
import com.devalse.devalse.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
@CrossOrigin
public class ProductController {
    private final ProductService service;

    @GetMapping
    ResponseEntity<List<ProductDto>> getAllProduct() {
        return new ResponseEntity(service.getAllProduct(), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<ProductDto> saveProduct(@RequestBody ProductDto dto) {
        return new ResponseEntity(service.save(dto), HttpStatus.CREATED);
    }

    @PutMapping
    ResponseEntity updateProduct(@RequestBody ProductDto dto, @PathVariable UUID categoryId) {
        service.updateProduct(dto, categoryId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping
    ResponseEntity deleteProduct(@RequestParam UUID id) {
        service.deleteProduct(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
