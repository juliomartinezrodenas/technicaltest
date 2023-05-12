package com.paradigmadigital.technicaltest.domain.port;

import com.paradigmadigital.technicaltest.domain.dto.GetPricesDTO;
import com.paradigmadigital.technicaltest.domain.entity.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository {
    List<Price> findPrices(LocalDateTime date, Integer productId, Integer brandId);
}
