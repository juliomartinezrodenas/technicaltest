package com.paradigmadigital.technicaltest.infrastructure.respository;

import com.paradigmadigital.technicaltest.infrastructure.adapter.PriceH2CustomRepository;
import com.paradigmadigital.technicaltest.infrastructure.entity.PriceH2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class PriceH2CustomRepositoryTest {
    private static final ZoneId zoneId = ZonedDateTime.now().getZone();
    private static final PriceH2 PRICE_1 = mockPriceH2(
            1,
            getOffsetDateTime(Month.JUNE, 14, 0),
            getOffsetDateTime(Month.DECEMBER, 31, 23, 59, 59),
            0,
            35.50
    );
    private static final PriceH2 PRICE_2 = mockPriceH2(
            2,
            getOffsetDateTime(Month.JUNE, 14, 15),
            getOffsetDateTime(Month.JUNE, 14, 18, 30, 0),
            1,
            25.45
    );

    private static final PriceH2 PRICE_3 = mockPriceH2(
            3,
            getOffsetDateTime(Month.JUNE, 15, 0),
            getOffsetDateTime(Month.JUNE, 15, 11),
            1,
            30.5
    );

    private static final PriceH2 PRICE_4 = mockPriceH2(
            4,
            getOffsetDateTime(Month.JUNE, 15, 16),
            getOffsetDateTime(Month.DECEMBER, 31, 23, 59, 59),
            1,
            38.95
    );

    @Autowired
    PriceH2CustomRepository repository;

    @Test
    void gets_prices_for_test1(){
        List<PriceH2> prices = getPriceByDate(getOffsetDateTime(Month.JUNE, 14, 10));
        assertEquals(List.of(PRICE_1), prices);
    }

    @Test
    void gets_prices_for_test2(){
        List<PriceH2> prices = getPriceByDate(getOffsetDateTime(Month.JUNE, 14, 16));
        assertEquals(List.of(PRICE_2, PRICE_1), prices);
    }

    @Test
    void gets_prices_for_test3(){
        List<PriceH2> prices = getPriceByDate(getOffsetDateTime(Month.JUNE, 14, 21));
        assertEquals(List.of(PRICE_1), prices);
    }

    @Test
    void gets_prices_for_test4(){
        List<PriceH2> prices = getPriceByDate(getOffsetDateTime(Month.JUNE, 15, 10));
        assertEquals(List.of(PRICE_3, PRICE_1), prices);
    }

    @Test
    void gets_prices_for_test5(){
        List<PriceH2> prices = getPriceByDate(getOffsetDateTime(Month.JUNE, 16, 21));
        assertEquals(List.of(PRICE_4, PRICE_1), prices);
    }

    private List<PriceH2> getPriceByDate(OffsetDateTime offsetDateTime) {
        return repository.findPrices(
                offsetDateTime,
                35455,
                1);
    }

    private static PriceH2 mockPriceH2(long id, OffsetDateTime startDate, OffsetDateTime endDate, int priority, double amount) {
        return PriceH2.builder()
                .priceId(id)
                .brandId(1)
                .productId(35455)
                .startDate(startDate)
                .endDate(endDate)
                .priority(priority)
                .price(BigDecimal.valueOf(amount).setScale(2, RoundingMode.HALF_DOWN))
                .currency("EUR")
                .build();
    }

    private static OffsetDateTime getOffsetDateTime(Month month, int day, int hour) {
        return getOffsetDateTime(month, day, hour, 0, 0);
    }


    private static OffsetDateTime getOffsetDateTime(Month month, int day, int hour, int minute, int second) {
        return ZonedDateTime.of(LocalDateTime.of(2020, month, day, hour, minute, second),
                zoneId).toOffsetDateTime();
    }
}
