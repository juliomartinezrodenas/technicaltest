package com.paradigmadigital.technicaltest.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetPricesDTO {
    private LocalDateTime date;
    private Integer brandId;
    private Integer productId;
}
