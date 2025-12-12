package org.codecop.dependencies.b;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class MarketingCampaign {
    private static final DayOfWeek CRAZY_SALES_DAY = DayOfWeek.FRIDAY;
    private final Clock clock;

    public MarketingCampaign() {
        this.clock = new Clock();
    }

    public MarketingCampaign(Clock clock) {
        this.clock = clock;
    }

    public boolean isActive() {
        return clock.currentTimeMillis() % 2 == 0;
    }

    public boolean isCrazySalesDay() {
        return clock.currentDayOfWeek().compareTo(CRAZY_SALES_DAY) == 0;
    }

    public static class Clock {
        public long currentTimeMillis() {
            return System.currentTimeMillis();
        }

        public DayOfWeek currentDayOfWeek() {
            return LocalDateTime.now().getDayOfWeek();
        }
    }
}
