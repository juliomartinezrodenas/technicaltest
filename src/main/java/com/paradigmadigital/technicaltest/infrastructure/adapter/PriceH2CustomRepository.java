package com.paradigmadigital.technicaltest.infrastructure.adapter;

import com.paradigmadigital.technicaltest.infrastructure.entity.PriceH2;

import java.time.OffsetDateTime;
import java.util.List;

interface PriceH2CustomRepository {
    List<PriceH2> findPrices(OffsetDateTime date, Integer productId, Integer brandId);

}
