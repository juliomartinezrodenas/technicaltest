package com.paradigmadigital.technicaltest.infrastructure.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
