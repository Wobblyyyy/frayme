package frayme.cherry;

/**
 * An executable that's executed in an async fashion. In essence, this means
 * that the {@link #execute()} method doesn't cause any blocking. Additionally,
 * this executable can be executed several times - but the event will only
 * be executed once. Make sense? Of course it does.
 */
public class AsyncExecutable implements Executable {
    private final Executable executable;
    private AsyncDispatcher dispatcher;

    public AsyncExecutable(Executable executable) {
        this.executable = executable;
        this.dispatcher = new AsyncDispatcher(new Thread(
                executable::execute
        ));
    }

    @Override
    public void execute() {
        if (dispatcher.isFinished()) {
            dispatcher.dispatch();
        } else {
            dispatcher = new AsyncDispatcher(new Thread(executable::execute));
        }
    }

    @Override
    public boolean isDone() {
        return executable.isDone();
    }
}
