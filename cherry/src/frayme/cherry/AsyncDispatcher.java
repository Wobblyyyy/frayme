package frayme.cherry;

/**
 * Container for a single thread. There can only be one of these threads
 * running at the same time. Attempting to start another thread will do
 * absolutely nothing - how safe and lovely!
 *
 * @author Colin Robertson
 */
public class AsyncDispatcher {
    /**
     * Has the dispatcher... dispatched? yet?
     */
    private boolean hasDispatched = false;

    /**
     * The dispatcher's thread. There's only one of these!
     */
    private final Thread thread;

    /**
     * Create a new {@code AsyncDispatcher}.
     *
     * @param thread the {@code Thread} that the dispatcher should use.
     */
    public AsyncDispatcher(Thread thread) {
        this.thread = thread;
    }

    /**
     * Attempt to dispatch the event. If the event has already been dispatched,
     * don't do anything at all.
     */
    public void dispatch() {
        if (!hasDispatched) {
            thread.start();
            hasDispatched = true;
        }
    }

    /**
     * Has the dispatcher finished?
     *
     * @return the opposite of the {@link Thread#isAlive()} method. This
     * method ({@code isFinished}) will return true if the thread is dead
     * and false if the thread is still alive.
     */
    public boolean isFinished() {
        return !thread.isAlive();
    }
}
