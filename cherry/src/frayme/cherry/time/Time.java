package frayme.cherry.time;

/**
 * A bunch of different utilities related to time. As a utility class, this
 * isn't instantiatable. Very unfortunate, I know.
 *
 * @author Colin Robertson
 */
public class Time {
    private Time() {

    }

    /**
     * Get the system's current time in milliseconds.
     *
     * @return the system's current time in milliseconds.
     */
    public static double ms() {
        return (double) System.currentTimeMillis();
    }

    /**
     * Convert between two different units of time.
     *
     * @param value    the value represented in original units.
     * @param original the original unit (to convert from).
     * @param target   the target unit (to convert to).
     * @return a converted measurement of time measured in target units.
     */
    public static double convert(double value,
                                 TimeUnit original,
                                 TimeUnit target) {
        double originalMs = original.getTimeInMs();
        double targetMs = target.getTimeInMs();

        return (value / originalMs) * value;
    }

    /**
     * Get a time, in milliseconds, that's TIME units away from now.
     *
     * @param time the amount of time in units.
     * @param unit the unit the time parameter is measured in.
     * @return a time, in milliseconds, that's TIME units away from now.
     */
    public static double fromNow(double time,
                                 TimeUnit unit) {
        double targetMs = unit.getTimeInMs() * time;

        return Time.ms() + time;
    }

    /**
     * @see Time#fromNow(double, TimeUnit)
     *
     * @param time milliseconds.
     * @return time from now, milliseconds.
     */
    public static double millisecondsFromNow(double time) {
        return fromNow(time, TimeUnit.MS);
    }

    /**
     * @see Time#fromNow(double, TimeUnit)
     *
     * @param time seconds.
     * @return time from now, milliseconds.
     */
    public static double secondsFromNow(double time) {
        return fromNow(time, TimeUnit.S);
    }

    /**
     * @see Time#fromNow(double, TimeUnit)
     *
     * @param time minutes.
     * @return time from now, milliseconds.
     */
    public static double minutesFromNow(double time) {
        return fromNow(time, TimeUnit.M);
    }

    /**
     * @see Time#fromNow(double, TimeUnit)
     *
     * @param time hours.
     * @return time from now, milliseconds.
     */
    public static double hoursFromNow(double time) {
        return fromNow(time, TimeUnit.H);
    }
}
