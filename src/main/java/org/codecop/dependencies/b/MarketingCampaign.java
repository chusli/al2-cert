package org.codecop.dependencies.b;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class MarketingCampaign {
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
        return clock.currentDayOfWeek().compareTo(DayOfWeek.FRIDAY) == 0;
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
