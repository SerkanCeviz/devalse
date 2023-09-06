package com.devalse.devalse.controller;

import lombok.RequiredArgsConstructor;
import com.devalse.devalse.model.CategoryDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.devalse.devalse.service.CategoryService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService service;

    @GetMapping
    ResponseEntity<List<CategoryDto>> getAllCategory() {
        return new ResponseEntity(service.getAllCategory(), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<CategoryDto> saveCategory(@RequestBody CategoryDto dto) {
        return new ResponseEntity(service.save(dto), HttpStatus.CREATED);
    }

    @PutMapping
    ResponseEntity updateCategory(@RequestBody CategoryDto dto) {
        service.updateCategory(dto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping
    ResponseEntity deleteCategory(@RequestParam UUID id) {
        service.deleteCategory(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
