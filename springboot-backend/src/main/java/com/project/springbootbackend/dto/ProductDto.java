package com.project.springbootbackend.dto;


import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
public class ProductDto {


    private long productId;
    private String name;
    private String description;
    private BigDecimal price;
    private int popularity;
    private String imageUrl;
    private Instant createdAt;
}
