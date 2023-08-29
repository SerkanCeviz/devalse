package model.mapper;

import entity.Product;
import model.ProductDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductDto entitytoDto(Product product);

    List<ProductDto> entityListtoDtoList(List<Product> products);

    Product dtotoEntity(ProductDto productDto);
}
