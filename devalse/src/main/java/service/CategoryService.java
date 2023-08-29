package service;

import entity.Category;
import lombok.RequiredArgsConstructor;
import model.CategoryDto;
import model.mapper.CategoryMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.CategoryRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryService {
    private final CategoryRepository repository;
    private final CategoryMapper categoryMapper;

    public List<CategoryDto> getAllCategory() {
        return categoryMapper.entityListtoDtoList(repository.findAll());
    }

    @Transactional
    public CategoryDto save(CategoryDto dto) {
        return categoryMapper.entitytoDto(repository.save(categoryMapper.dtotoEntity(dto)));
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
