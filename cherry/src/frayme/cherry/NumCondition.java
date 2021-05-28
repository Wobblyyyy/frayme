package frayme.cherry;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

/**
 * A {@code BooleanSupplier} to be used with {@code Conditional}s and
 * {@code ConditionSet}s.
 *
 * @param <E> a type (which extends {@link Number}) that the condition
 *            is based upon.
 */
public class NumCondition<E extends Number> implements BooleanSupplier {
    /**
     * A supplier that gets values for the condition.
     */
    private final Supplier<E> supplier;

    /**
     * A minimum value.
     */
    private final double minimum;

    /**
     * A maximum value.
     */
    private final double maximum;

    /**
     * Create a new {@code NumCondition}.
     *
     * @param supplier a supplier that provides numbers to check for.
     * @param minimum  a minimum value.
     * @param maximum  a maximum value.
     */
    public NumCondition(Supplier<E> supplier,
                        E minimum,
                        E maximum) {
        this.supplier = supplier;
        this.minimum = minimum.doubleValue();
        this.maximum = maximum.doubleValue();
    }

    /**
     * Evaluate the condition based on a value queried from the conditional's
     * number supplier.
     *
     * @return whether or not the supplied number fits within the range.
     */
    @Override
    public boolean getAsBoolean() {
        double value = supplier.get().doubleValue();

        return minimum < value && value < maximum;
    }
}
