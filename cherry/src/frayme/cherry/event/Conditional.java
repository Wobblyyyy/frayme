package frayme.cherry.event;

import java.util.function.Predicate;
import java.util.function.Supplier;

public class Conditional<E> {
    private final Predicate<E> predicate;

    private final Supplier<E> condition;

    public Conditional(Predicate<E> predicate,
                       Supplier<E> condition) {
        this.predicate = predicate;
        this.condition = condition;
    }

    public boolean isValid() {
        return predicate.test(condition.get());
    }
}
