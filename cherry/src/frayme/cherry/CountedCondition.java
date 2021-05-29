package frayme.cherry;

import java.util.function.BooleanSupplier;

/**
 * A condition that depends on the amount of times the condition's state
 * has been checked. Each time the condition is checked by invoking the
 * {@link #getAsBoolean()} method, an internal counter is incremented. The
 * condition will return true if the execution count is greater than the
 * minimum count and lesser than the maximum count. The counter is updated
 * before the count is compared - in other words, you won't ever have a count
 * value of 0.
 *
 * @author Colin Robertson
 */
public class CountedCondition implements BooleanSupplier {
    /**
     * The minimum count value that will make the condition return true.
     */
    private final int minimumCount;

    /**
     * The maximum count value that will make the condition return true.
     */
    private final int maximumCount;

    /**
     * The amount of times the condition has been checked.
     *
     * <p>
     * This value is updated before the {@link #getAsBoolean()} method returns
     * a value.
     * </p>
     */
    private int count = 0;

    /**
     * Create a new {@code CountedCondition}.
     *
     * @param minimumCount the minimum count value required for the condition
     *                     to return true.
     * @param maximumCount the maximum count value required for the condition
     *                     to return true.
     */
    public CountedCondition(int minimumCount,
                            int maximumCount) {
        this.minimumCount = minimumCount;
        this.maximumCount = maximumCount;
    }

    /**
     * If the current count value (incremented first thing when this method
     * is invoked) is greater than the minimum count value and lesser than
     * the maximum count value, return true. Otherwise, return false.
     *
     * @return whether or not the current count value fits within the provided
     * bounds for the {@code CountedCondition}.
     */
    @Override
    public boolean getAsBoolean() {
        count++;

        return minimumCount < count && count < maximumCount;
    }
}
