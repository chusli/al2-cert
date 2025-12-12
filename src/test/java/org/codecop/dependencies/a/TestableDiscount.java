package org.codecop.dependencies.a;

public class TestableDiscount extends Discount {
    public TestableDiscount() {
        super(new TestableMarketingCampaign(false, false));
    }

    public TestableDiscount(boolean isCrazySalesDay, boolean isActive) {
        super(new TestableMarketingCampaign(isCrazySalesDay, isActive));
    }
}
