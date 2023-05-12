package com.paradigmadigital.technicaltest.infrastructure.rest;

import com.paradigmadigital.technicaltest.domain.dto.GetPricesDTO;
import com.paradigmadigital.technicaltest.domain.entity.Price;
import com.paradigmadigital.technicaltest.application.PriceService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
@AllArgsConstructor
public class PricesController {

    private final PriceService priceService;

    @PostMapping
    public ResponseEntity<List<Price>> getPrices(@RequestBody GetPricesDTO getPricesDTO){
        return new ResponseEntity<>(this.priceService.getPrices(getPricesDTO), HttpStatus.OK);
    }
}
