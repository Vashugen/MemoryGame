package games.shmugen.memorygame.events.ui;

import games.shmugen.memorygame.events.AbstractEvent;
import games.shmugen.memorygame.events.EventObserver;

public class BackGameEvent extends AbstractEvent {

    public static final String TYPE = BackGameEvent.class.getName();

    @Override
    protected void fire(EventObserver eventObserver) {
        eventObserver.onEvent(this);
    }

    @Override
    public String getType() {
        return null;
    }
}
