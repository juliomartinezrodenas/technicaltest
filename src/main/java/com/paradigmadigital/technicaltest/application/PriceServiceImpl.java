package com.paradigmadigital.technicaltest.application;

import com.paradigmadigital.technicaltest.domain.dto.FindPricesDTO;
import com.paradigmadigital.technicaltest.domain.entity.Price;
import com.paradigmadigital.technicaltest.domain.port.PriceRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PriceServiceImpl implements PriceService {

  private PriceRepository priceRepository;

  @Override
  public List<Price> findPrices(FindPricesDTO filter) {
    return priceRepository.findPrices(filter.getDate(), filter.getProductId(), filter.getBrandId());
  }
}
