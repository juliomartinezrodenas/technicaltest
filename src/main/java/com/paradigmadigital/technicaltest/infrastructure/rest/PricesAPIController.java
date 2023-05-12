package com.paradigmadigital.technicaltest.infrastructure.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paradigmadigital.technicaltest.application.PriceService;
import com.paradigmadigital.technicaltest.domain.dto.FindPricesDTO;
import com.paradigmadigital.technicaltest.domain.entity.Price;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-05-11T22:55:44.106427175Z[GMT]")
@RestController
@Slf4j
@AllArgsConstructor
public class PricesAPIController implements PricesAPI {

    private final ObjectMapper objectMapper;
    private final PriceService priceService;

    public ResponseEntity<List<Price>> apiPost(
            @RequestHeader HttpHeaders headers,
            @Parameter(
                    in = ParameterIn.DEFAULT,
                    description = "The request body takes a FindPricesDTO schema object with the filtering parameters",
                    required=true,
                    schema=@Schema())
            @Valid @RequestBody FindPricesDTO body) {
        var accept = headers.getAccept();
        if (accept.contains(MediaType.APPLICATION_JSON) || accept.contains(MediaType.ALL)) {
            return new ResponseEntity<>(this.priceService.findPrices(body), HttpStatus.OK);
        }
        return new ResponseEntity<List<Price>>(HttpStatus.NOT_IMPLEMENTED);
    }

}
