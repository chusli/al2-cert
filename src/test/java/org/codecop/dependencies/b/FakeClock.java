package org.codecop.dependencies.b;

import org.codecop.dependencies.b.MarketingCampaign.Clock;

import java.time.DayOfWeek;

public class FakeClock extends Clock {

    private final long currentTimeMillis;
    private final DayOfWeek dayOfWeek;

    public FakeClock(long currentTimeMillis, DayOfWeek dayOfWeek) {
        this.currentTimeMillis = currentTimeMillis;
        this.dayOfWeek = dayOfWeek;
    }


    @Override
    public DayOfWeek currentDayOfWeek() {
        return dayOfWeek;
    }

    @Override
    public long currentTimeMillis() {
        return currentTimeMillis;
    }
}
