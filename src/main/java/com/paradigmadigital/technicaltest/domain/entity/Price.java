package com.paradigmadigital.technicaltest.domain.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Price {
    private int brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int priceId;
    private int productId;
    private int priority;
    private BigDecimal price;
    private String currency;
}
