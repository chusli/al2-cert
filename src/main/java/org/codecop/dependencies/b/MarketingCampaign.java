package org.codecop.dependencies.b;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class MarketingCampaign {

    public boolean isActive() {
        return isCampaingActive();
    }

    public boolean isCrazySalesDay() {
        return isTodayAFriday();
    }

    boolean isCampaingActive() {
        return System.currentTimeMillis() % 2 == 0;
    }

    boolean isTodayAFriday() {
        return LocalDateTime.now().getDayOfWeek().compareTo(DayOfWeek.FRIDAY) == 0;
    }

}
