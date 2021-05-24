package frayme.cherry.event;

import java.util.List;
import java.util.function.Supplier;

public class PredicatedEvent implements Event {
    private final Event event;

    private final List<Supplier<Boolean>> predicates;

    public PredicatedEvent(Event event,
                           List<Supplier<Boolean>> predicates) {
        this.event = event;
        this.predicates = predicates;
    }

    public void require(Supplier<Boolean> predicate) {
        this.predicates.add(predicate);
    }

    public void unrequire(Supplier<Boolean> predicate) {
        this.predicates.remove(predicate);
    }

    @Override
    public void run() {
        boolean canExecute = true;

        for (Supplier<Boolean> s : predicates) {
            if (!s.get()) canExecute = false;
        }

        if (canExecute) event.run();
    }
}
