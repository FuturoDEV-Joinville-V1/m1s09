package br.futurodev.joiville.m1s09.services;

import br.futurodev.joiville.m1s09.dtos.products.ProductRequestDto;
import br.futurodev.joiville.m1s09.dtos.products.ProductResponseDto;
import br.futurodev.joiville.m1s09.entities.Product;
import br.futurodev.joiville.m1s09.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ProductResponseDto> findAll() {
        List<Product> products = repository.findAll();
        List<ProductResponseDto> response = new ArrayList<>();

        for (Product product : products) {
            response.add(new ProductResponseDto(
                    product.getId(),
                    product.getName(),
                    product.getDescription(),
                    product.getSku(),
                    product.getStockQuantity(),
                    product.getPrice()
            ));
        }

        return response;
    }

    @Override
    public ProductResponseDto findById(Long id) {
        Product product = findEntityById(id);
        if (product != null) {
            return new ProductResponseDto(
                    product.getId(),
                    product.getName(),
                    product.getDescription(),
                    product.getSku(),
                    product.getStockQuantity(),
                    product.getPrice()
            );
        }
        return null;
    }

    @Override
    public ProductResponseDto create(ProductRequestDto dto) {
        return save(new Product(), dto);
    }

    @Override
    public ProductResponseDto update(Long id, ProductRequestDto dto) {
        Product product = findEntityById(id);
        return save(product, dto);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Product findEntityById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public ProductResponseDto save(Product product, ProductRequestDto dto) {
        product.setName(dto.name());
        product.setDescription(dto.description());
        product.setSku(dto.sku());
        product.setStockQuantity(dto.stockQuantity());
        product.setPrice(dto.price());

        product = repository.save(product);

        return new ProductResponseDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getSku(),
                product.getStockQuantity(),
                product.getPrice()
        );
    }

}
