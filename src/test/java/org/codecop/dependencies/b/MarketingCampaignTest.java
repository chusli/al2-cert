package org.codecop.dependencies.b;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class MarketingCampaignTest {

    @Test
    public void noCrazySalesDay() {
        MarketingCampaign campaign = new TestableMarketingCampaign(false, false);

        boolean isCrazySalesDay = campaign.isCrazySalesDay();

        assertFalse(isCrazySalesDay);
    }

    @Test
    public void noActiveCampaign() {
        MarketingCampaign campaign = new TestableMarketingCampaign(false, false);

        boolean active = campaign.isActive();

        assertFalse(active);
    }
}
