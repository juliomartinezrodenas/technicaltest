package com.paradigmadigital.technicaltest.application;

import com.paradigmadigital.technicaltest.domain.dto.FindPricesDTO;
import com.paradigmadigital.technicaltest.domain.entity.Price;
import java.util.List;

public interface PriceService {

  List<Price> findPrices(FindPricesDTO filter);
}
