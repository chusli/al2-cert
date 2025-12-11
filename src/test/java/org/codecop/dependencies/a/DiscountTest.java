package org.codecop.dependencies.a;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class DiscountTest {

    @org.junit.jupiter.api.Test
    public void test1() {
        Discount discount = new Discount();

        Money net = new Money(1002);
        Money total = discount.discountFor(net);

        assertEquals(new Money(new BigDecimal("901.8")), total);
    }

}
