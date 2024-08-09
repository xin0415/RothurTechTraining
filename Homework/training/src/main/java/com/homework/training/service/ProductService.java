package com.homework.training.service;

import com.homework.training.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProduct();
    ProductDto getProductById(Long id);
    ProductDto createProduct(ProductDto productDto);
}
