package com.devalse.devalse.model.mapper;

import com.devalse.devalse.entity.Product;
import com.devalse.devalse.model.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto entitytoDto(Product product);

    List<ProductDto> entityListtoDtoList(List<Product> products);

    Product dtotoEntity(ProductDto productDto);
}
