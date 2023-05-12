package com.paradigmadigital.technicaltest.application;

import com.paradigmadigital.technicaltest.domain.dto.GetPricesDTO;
import com.paradigmadigital.technicaltest.domain.entity.Price;
import com.paradigmadigital.technicaltest.domain.port.PriceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PriceServiceImpl implements PriceService{
    private PriceRepository priceRepository;
    @Override
    public List<Price> getPrices(GetPricesDTO filter) {
        return priceRepository.findPrices(filter.getDate(), filter.getProductId(), filter.getBrandId());
    }
}
