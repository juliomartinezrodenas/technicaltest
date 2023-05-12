package com.paradigmadigital.technicaltest.infrastructure.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@Entity
@Table(name = "prices")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
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
