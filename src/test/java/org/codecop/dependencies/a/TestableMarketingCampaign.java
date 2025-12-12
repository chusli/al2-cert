package org.codecop.dependencies.a;

public class TestableMarketingCampaign extends MarketingCampaign {
    private final boolean isCrazySalesDay;
    private final boolean isActive;

    public TestableMarketingCampaign(boolean isCrazySalesDay, boolean isActive) {
        this.isCrazySalesDay = isCrazySalesDay;
        this.isActive = isActive;
    }

    @Override
    public boolean isCrazySalesDay() {
        return isCrazySalesDay;
    }

    @Override
    public boolean isActive() {
        return isActive;
    }

}
