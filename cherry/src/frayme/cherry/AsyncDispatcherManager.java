package frayme.cherry;

public class AsyncDispatcherManager {
    private static Thread getThread(Runnable runnable) {
        return new Thread(runnable);
    }

    private static AsyncDispatcher getDispatcher(Runnable runnable) {
        return new AsyncDispatcher(
                getThread(
                        runnable
                )
        );
    }

    public AsyncDispatcherManager() {

    }

    public AsyncDispatcher dispatch(Executable executable) {
        AsyncDispatcher dispatcher = getDispatcher(executable::execute);
        dispatcher.dispatch();
        return dispatcher;
    }
}
