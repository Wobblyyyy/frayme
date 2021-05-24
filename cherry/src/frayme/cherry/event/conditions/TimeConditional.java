package frayme.cherry.event.conditions;

public class TimeConditional extends RangeConditional {
    private static Double ms() {
        return (double) System.currentTimeMillis();
    }

    public TimeConditional(double min,
                           double max) {
        super(min, max, TimeConditional::ms);
    }
}
