package com.paradigmadigital.technicaltest.infrastructure.rest;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.paradigmadigital.technicaltest.application.PriceService;
import com.paradigmadigital.technicaltest.domain.dto.FindPricesDTO;
import com.paradigmadigital.technicaltest.domain.entity.Price;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(PricesAPIController.class)
class PricesAPIControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private PriceService service;

  @Test
  void endpoint_responds_correctly() throws Exception {
    when(service.findPrices(Mockito.any(FindPricesDTO.class))).thenReturn(new ArrayList<Price>());
    testGetPrices(LocalDateTime.of(2020, Month.JUNE, 14, 10, 0),
        35455,
        1,
        """
            []
            """);
  }

  private void testGetPrices(LocalDateTime localDateTime, Integer productId, Integer brandId,
      String expected) throws Exception {
    var requestJson = """
        {
            "date" : "%s",
            "brandId" : "%s",
            "productId" : "%s"
        }
        """.formatted(OffsetDateTime.of(localDateTime, OffsetDateTime.now().getOffset()), brandId,
        productId);
    mockMvc.perform(post("/api")
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestJson))
        .andExpect(status().isOk())
        .andExpect(content().json(expected));
  }
}
