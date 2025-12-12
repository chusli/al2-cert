package org.codecop.dependencies.c;

import java.util.ArrayList;
import java.util.List;

public class TestableCheckout extends Checkout {
    private final List<Receipt> receipts = new ArrayList<>();

    @Override
    void persist(Receipt receipt) {
        this.receipts.add(receipt);
    }
}
