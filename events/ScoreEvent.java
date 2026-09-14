package events;

import java.util.ArrayList;
import java.util.List;

public class ScoreEvent {
    private static final List<Runnable> xListeners = new ArrayList<>();

    // Call this to register a new function
    public static void subscribeTo(Runnable listener) {
        xListeners.add(listener);
    }

    // Call this when X happens
    public static void fireEvent() {
        for (Runnable listener : xListeners) {
            listener.run(); // Executes every registered function
        }
    }
}
