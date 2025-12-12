package org.codecop.dependencies.b;

public class TestableMarketingCampaign extends MarketingCampaign {
    private final boolean isTodayAFriday;
    private final boolean isActive;

    public TestableMarketingCampaign(boolean isTodayAFriday, boolean isActive) {
        this.isTodayAFriday = isTodayAFriday;
        this.isActive = isActive;
    }

    @Override
    boolean isTodayAFriday() {
        return isTodayAFriday;
    }

    @Override
    boolean isCampaingActive() {
        return isActive;
    }
}
