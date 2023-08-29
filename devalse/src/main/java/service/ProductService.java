package service;

import entity.Product;
import lombok.RequiredArgsConstructor;
import model.ProductDto;
import model.mapper.ProductMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.ProductRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {

    private final ProductMapper mapper;
    private final ProductRepository repository;

    public List<ProductDto> getAllProduct() {
        return mapper.entityListtoDtoList(repository.findAll());
    }

    @Transactional
    public ProductDto save(ProductDto dto) {
        return mapper.entitytoDto(repository.save(mapper.dtotoEntity(dto)));
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
