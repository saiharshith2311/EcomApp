package com.project.springbootbackend.service;

import com.project.springbootbackend.dto.ProductDto;

import java.util.List;

public interface IProductService {

    public List<ProductDto> getProducts();
}
