package com.paradigmadigital.technicaltest.infrastructure.adapter;

import com.paradigmadigital.technicaltest.domain.entity.Price;
import com.paradigmadigital.technicaltest.domain.port.PriceRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class PriceH2Repository implements PriceRepository {
    private final PriceH2CustomRepository priceH2CustomRepository;
    private static final ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<Price> findPrices(OffsetDateTime date, Integer productId, Integer brandId) {
        return priceH2CustomRepository.findPrices(date, productId, brandId).stream()
                .map(priceH2 -> modelMapper.map(priceH2, Price.class))
                .collect(Collectors.toList());
    }
}
