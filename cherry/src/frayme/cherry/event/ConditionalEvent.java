package frayme.cherry.event;

public interface ConditionalEvent<E> extends Event {
    boolean canRun(E condition);

    default void checkedRun(E condition) {
        if (canRun(condition)) this.run();
    }
}
