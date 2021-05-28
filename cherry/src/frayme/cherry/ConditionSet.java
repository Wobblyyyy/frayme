package frayme.cherry;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

/**
 * An {@link Executable} that only executes under a certain set of conditions.
 * These conditions are supplied through a {@code List} containing suppliers.
 * In order to determine if execution should be allowed to proceed, the
 * {@code Conditional} will evaluate each of these conditions.
 *
 * @author Colin Robertson
 */
public class ConditionSet {
    /**
     * A set of conditions the {@code Executable} must meet in order to execute.
     */
    private final List<BooleanSupplier> conditions;

    /**
     * Create a new {@code ConditionSet} event without any conditions.
     *
     * <p>
     * Conditions can be added using these methods:
     * <ul>
     *     <li>{@link #require(BooleanSupplier)}</li>
     *     <li>{@link #unrequire(BooleanSupplier)}</li>
     * </ul>
     * </p>
     */
    public ConditionSet() {
        this(new ArrayList<>());
    }

    /**
     * Create a new {@code ConditionSet} with a predefined set of conditions.
     *
     * @param conditions a set of conditions required for execution.
     */
    public ConditionSet(List<BooleanSupplier> conditions) {
        this.conditions = conditions;
    }

    /**
     * Require a specific supplier's return value to be true in order for the
     * event to execute.
     *
     * @param supplier the supplier required for event execution.
     */
    public void require(BooleanSupplier supplier) {
       this.conditions.add(supplier);
    }

    /**
     * Unrequire a specific supplier's return value to be true in order for the
     * event to execute.
     *
     * @param supplier the supplier required for event execution.
     */
    public void unrequire(BooleanSupplier supplier) {
        this.conditions.remove(supplier);
    }

    /**
     * Is a specified condition required for execution?
     *
     * @param supplier the supplier to check for.
     * @return whether the provided supplier is required.
     */
    public boolean isRequired(BooleanSupplier supplier) {
        return this.conditions.contains(supplier);
    }

    /**
     * Get a count of how many requirements the {@code Conditional} has.
     *
     * @return a count of how many requirements.
     */
    public int requirementCount() {
        return this.conditions.size();
    }

    /**
     * Get an array of boolean values gathered by evaluating each of the
     * individual suppliers.
     *
     * @return an array of boolean values.
     */
    public boolean[] evaluate() {
        boolean[] evaluated = new boolean[this.conditions.size()];

        for (int i = 0; i < this.conditions.size(); i++) {
            evaluated[i] = this.conditions.get(i).getAsBoolean();
        }

        return evaluated;
    }

    /**
     * Do all of the events in the {@code Conditional} return true?
     *
     * @return if all of the conditions in the event's list return true, this
     * method will return true. If any of those conditions return false,
     * however, this method will return false.
     */
    public boolean doesPass() {
        for (BooleanSupplier condition : this.conditions) {
            if (!condition.getAsBoolean()) return false;
        }

        return true;
    }

    /**
     * The exact opposite of the {@link #doesPass()} method.
     *
     * @return the exact opposite of the {@link #doesPass()} method.
     */
    public boolean doesFail() {
        return !doesPass();
    }
}
