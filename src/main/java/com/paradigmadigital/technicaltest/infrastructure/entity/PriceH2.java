package com.paradigmadigital.technicaltest.infrastructure.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@Entity
@Table(name = "prices")
public class PriceH2 {
    @Id
    private Long priceId;
    private Integer brandId;
    private OffsetDateTime startDate;
    private OffsetDateTime endDate;
    private Integer productId;
    private Integer priority;
    private BigDecimal price;
    private String currency;
}
