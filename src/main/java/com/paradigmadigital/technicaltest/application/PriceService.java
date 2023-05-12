package com.paradigmadigital.technicaltest.application;

import com.paradigmadigital.technicaltest.domain.dto.GetPricesDTO;
import com.paradigmadigital.technicaltest.domain.entity.Price;

import java.util.List;

public interface PriceService {
    List<Price> getPrices(GetPricesDTO filter);
}
