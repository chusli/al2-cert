package org.codecop.dependencies.a;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiscountTest {

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
        Discount discount = new TestableDiscount();

        Money net = new Money(110);
        Money total = discount.discountFor(net);
        assertEquals(new Money(new BigDecimal("110")), total);
    }

    @Test
    void whenCrazyDiscountActiveThenReturnDiscountBy15() {
        Discount discount = new TestableDiscount(true, true);

        Money net = new Money(100);
        Money total = discount.discountFor(net);

        assertEquals(new Money(new BigDecimal("85")), total);
    }

}
