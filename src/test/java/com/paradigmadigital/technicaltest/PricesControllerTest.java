package com.paradigmadigital.technicaltest;

import com.paradigmadigital.technicaltest.infrastructure.rest.PricesAPIController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.time.Month;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PricesAPIController.class)
public class PricesControllerTest {
    @Autowired
    private MockMvc mockMvc;

    //@Test
    public void findPrices_test1() throws Exception {
        testGetPrices(LocalDateTime.of(2020, Month.JUNE,14,10,0),
                35455,
                1,
                """
                        []
                        """);
    }

    private void testGetPrices(LocalDateTime localDateTime, Integer productId, Integer brandId, String expected) throws Exception {
        var requestJson = """
                {
                    "date" : "%s",
                    "brandId" : "%s",
                    "productId" : "%s"
                }
                """.formatted(localDateTime, brandId, productId);
        mockMvc.perform(post("/api")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(content().json(expected));
    }
}
