package model.mapper;

import entity.Category;
import model.CategoryDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {

    CategoryDto entitytoDto(Category category);

    List<CategoryDto> entityListtoDtoList(List<Category> categories);

    Category dtotoEntity(CategoryDto categoryDto);
}
