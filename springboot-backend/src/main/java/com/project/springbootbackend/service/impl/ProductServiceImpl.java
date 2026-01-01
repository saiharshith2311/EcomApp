package com.project.springbootbackend.service.impl;

import com.project.springbootbackend.dto.ProductDto;
import com.project.springbootbackend.entity.Product;
import com.project.springbootbackend.repository.ProductRepository;
import com.project.springbootbackend.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {
    private final ProductRepository productRepository;

    @Override
    @Cacheable("products")
    public List<ProductDto> getProducts() {
        return productRepository.findAll().stream().map(this::transformToDto).collect(Collectors.toList());
    }

    private ProductDto transformToDto(Product product) {
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        productDto.setProductId(product.getProductId());
        return productDto;

    }
}
