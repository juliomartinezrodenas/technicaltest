package com.paradigmadigital.technicaltest.infrastructure.adapter;

import com.paradigmadigital.technicaltest.infrastructure.entity.PriceH2;

import java.time.LocalDateTime;
import java.util.List;

interface PriceH2CustomRepository {
    List<PriceH2> findPrices(LocalDateTime date, Integer productId, Integer brandId);

}
