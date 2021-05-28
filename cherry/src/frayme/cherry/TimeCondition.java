package frayme.cherry;

import frayme.cherry.time.Time;

/**
 * An extension of the {@link NumCondition} that uses the system's current
 * time in milliseconds as the supplied double value.
 */
public class TimeCondition extends NumCondition<Double> {
    /**
     * Create a new {@code TimeCondition}.
     *
     * @param minimum  a minimum value.
     * @param maximum  a maximum value.
     */
    public TimeCondition(Double minimum, Double maximum) {
        super(Time::ms, minimum, maximum);
    }
}
