package com.devalse.devalse.service;

import com.devalse.devalse.entity.Category;
import com.devalse.devalse.model.CategoryDto;
import com.devalse.devalse.model.mapper.CategoryMapper;
import com.devalse.devalse.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryService {
    private final CategoryRepository repository;

    public List<CategoryDto> getAllCategory() {
        return CategoryMapper.INSTANCE.entityListtoDtoList(repository.findAll());
    }

    @Transactional
    public CategoryDto save(CategoryDto dto) {
        return CategoryMapper.INSTANCE.entitytoDto(repository.save(CategoryMapper.INSTANCE.dtotoEntity(dto)));
    }

    @Transactional
    public void updateCategory(CategoryDto dto) {
        repository.findById(dto.getId()).ifPresent(item -> {
            item.setName(dto.getName());
        });
    }

    @Transactional
    public void deleteCategory(UUID id) {
        Category category = repository.findById(id).orElseThrow();
        repository.delete(category);
    }
}
