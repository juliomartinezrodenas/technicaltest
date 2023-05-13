package com.paradigmadigital.technicaltest.domain.port;

import com.paradigmadigital.technicaltest.domain.entity.Price;
import java.time.OffsetDateTime;
import java.util.List;

public interface PriceRepository {

  List<Price> findPrices(OffsetDateTime date, Integer productId, Integer brandId);
}
