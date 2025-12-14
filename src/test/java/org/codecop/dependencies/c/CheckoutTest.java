package org.codecop.dependencies.c;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

public class CheckoutTest {

    @Test
    public void createReceipt() {
        Checkout checkout = new TestableCheckout();

        checkout.createReceipt(new Money(12));

        assertNotNull(checkout);
    }

    @Test
    public void createReceiptSetsAmount() {
        TestableCheckout checkout = new TestableCheckout();

        checkout.createReceipt(new Money(12));

        List<Receipt> receipts = checkout.getReceipts();
        assertThat(receipts).hasSize(1);
        Receipt receipt = receipts.getFirst();
        assertThat(receipt.getAmount())
                .usingRecursiveComparison()
                .isEqualTo(new Money(new BigDecimal("12")));
    }

    @Test
    public void createReceiptSetsVat() {
        TestableCheckout checkout = new TestableCheckout();

        checkout.createReceipt(new Money(12));

        List<Receipt> receipts = checkout.getReceipts();
        assertThat(receipts).hasSize(1);
        Receipt receipt = receipts.getFirst();
        assertThat(receipt.getTax())
                .usingRecursiveComparison()
                .isEqualTo(new Money(new BigDecimal("2.4")));
    }

    @Test
    public void createReceiptSetsTotal() {
        TestableCheckout checkout = new TestableCheckout();

        checkout.createReceipt(new Money(12));

        List<Receipt> receipts = checkout.getReceipts();
        assertThat(receipts).hasSize(1);
        Receipt receipt = receipts.getFirst();
        assertThat(receipt.getTotal())
                .usingRecursiveComparison()
                .isEqualTo(new Money(new BigDecimal("14.4")));
    }


}
