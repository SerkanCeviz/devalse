package com.devalse.devalse.model.mapper;

import com.devalse.devalse.entity.Category;
import com.devalse.devalse.model.CategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDto entitytoDto(Category category);

    List<CategoryDto> entityListtoDtoList(List<Category> categories);

    Category dtotoEntity(CategoryDto categoryDto);
}
