package com.homework.training.service.impl;

import com.homework.training.dto.ProductDto;
import com.homework.training.entity.Product;
import com.homework.training.exception.ResourceNotFoundException;
import com.homework.training.mapper.ProductMapper;
import com.homework.training.repository.ProductRepository;
import com.homework.training.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    @Override
    public List<ProductDto> getAllProduct() {
        List<Product> products= productRepository.findAll();
        return products.stream().map(product -> ProductMapper.mapToProductDto(product))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto getProductById(Long id) {
        Product product=productRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Product not found with id: " + id));
        return ProductMapper.mapToProductDto(product);
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = ProductMapper.mapToProduct(productDto);
        Product savedProduct=productRepository.save(product);
        return ProductMapper.mapToProductDto(savedProduct);
    }
}
