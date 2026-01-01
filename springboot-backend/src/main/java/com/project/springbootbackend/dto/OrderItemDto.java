package com.project.springbootbackend.dto;

import java.math.BigDecimal;

public record OrderItemDto(Long productId,
                           Integer quantity, BigDecimal price) {

}
