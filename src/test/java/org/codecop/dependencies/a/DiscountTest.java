package org.codecop.dependencies.a;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiscountTest {

    static Stream<Arguments> provideEdgeCases() {
        return Stream.of(
                Arguments.arguments(new Money(100), new Money(100)),
                Arguments.arguments(new Money(1000), new Money(950))
        );
    }

    @Test
    public void discountForOver1000() {
        Discount discount = new TestableDiscount();

        Money net = new Money(1002);
        Money total = discount.discountFor(net);

        assertEquals(new Money(new BigDecimal("901.8")), total);
    }

    @Test
    void whenUnder100ThenReturnNoDiscount() {
        Discount discount = new TestableDiscount();

        Money net = new Money(12);
        Money total = discount.discountFor(net);

        assertEquals(new Money(new BigDecimal("12")), total);
    }

    @Test
    void whenOver100ThenReturnDiscountBy5() {
        Discount discount = new TestableDiscount(false, true);

        Money net = new Money(200);
        Money total = discount.discountFor(net);

        assertEquals(new Money(new BigDecimal("190")), total);
    }

    @Test
    void whenDiscountNotActiveReturnNetPrice() {
        Discount discount = new TestableDiscount(false, false);

        Money net = new Money(110);
        Money total = discount.discountFor(net);
        assertEquals(new Money(new BigDecimal("110")), total);
    }


    @Test
    void whenCrazySalesDayThenOverwrite10PercentSale() {
        Discount discount = new TestableDiscount(true, true);

        Money net = new Money(2000);
        Money total = discount.discountFor(net);

        assertEquals(new Money(new BigDecimal("1700")), total);
    }


    @Test
    void whenCrazySalesDayThenOverwrite5PercentSale() {
        Discount discount = new TestableDiscount(true, true);

        Money net = new Money(100);
        Money total = discount.discountFor(net);

        assertEquals(new Money(new BigDecimal("85")), total);
    }

    @ParameterizedTest
    @MethodSource("provideEdgeCases")
    void edgeCases(Money netPrice, Money expectedPrice) {
        Discount discount = new TestableDiscount(false, true);

        Money total = discount.discountFor(netPrice);

        assertEquals(expectedPrice, total);
    }
}
