package frayme.cherry.event;

import java.util.ArrayList;
import java.util.List;

public class EventExecutor implements Event {
    private final List<Event> events = new ArrayList<>();

    public EventExecutor() {

    }

    public void executeEvent(Event event) {
        event.run();
    }

    @Override
    public void run() {
        for (Event e : events) {
            executeEvent(e);
        }
    }
}
