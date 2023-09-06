package com.devalse.devalse.service;

import com.devalse.devalse.entity.Product;
import lombok.RequiredArgsConstructor;
import com.devalse.devalse.model.ProductDto;
import com.devalse.devalse.model.mapper.ProductMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.devalse.devalse.repository.ProductRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {

    private final ProductRepository repository;

    public List<ProductDto> getAllProduct() {
        return ProductMapper.INSTANCE.entityListtoDtoList(repository.findAll());
    }

    @Transactional
    public ProductDto save(ProductDto dto) {
        return ProductMapper.INSTANCE.entitytoDto(repository.save(ProductMapper.INSTANCE.dtotoEntity(dto)));
    }

    @Transactional
    public void updateProduct(ProductDto dto) {
        repository.findById(dto.getId()).ifPresent(item -> {
            item.setName(dto.getName());
            item.setPrice(dto.getPrice());
            item.setImagePath(dto.getImagePath());
            item.setCategory(dto.getCategory());
        });
    }

    @Transactional
    public void deleteProduct(UUID id) {
        Product product = repository.findById(id).orElseThrow();
        repository.delete(product);
    }
}
