package org.codecop.dependencies.c;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class CheckoutTest {

    @Test
    public void createReceipt() {
        Checkout checkout = new TestableCheckout();

        checkout.createReceipt(new Money(12));

        assertNotNull(checkout);
    }
}
