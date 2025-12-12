package org.codecop.dependencies.b;

import org.junit.Test;

import java.time.DayOfWeek;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MarketingCampaignTest {

    @Test
    public void noCrazySalesDay() {
        MarketingCampaign campaign = new MarketingCampaign(new FakeClock(0, DayOfWeek.SUNDAY));

        boolean isCrazySalesDay = campaign.isCrazySalesDay();

        assertFalse(isCrazySalesDay);
    }

    @Test
    public void isCraySalesDay() {
        MarketingCampaign campaign = new MarketingCampaign(new FakeClock(0, DayOfWeek.FRIDAY));

        boolean isCrazySalesDay = campaign.isCrazySalesDay();

        assertTrue(isCrazySalesDay);
    }

    @Test
    public void noActiveCampaign() {
        MarketingCampaign campaign = new MarketingCampaign(new FakeClock(1, DayOfWeek.MONDAY));

        boolean active = campaign.isActive();

        assertFalse(active);
    }

    @Test
    public void isActiveCampaign() {
        MarketingCampaign campaign = new MarketingCampaign(new FakeClock(2, DayOfWeek.MONDAY));

        boolean active = campaign.isActive();

        assertTrue(active);
    }
}
