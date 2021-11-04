package games.shmugen.memorygame.events.ui;

import games.shmugen.memorygame.events.AbstractEvent;
import games.shmugen.memorygame.events.EventObserver;

public class ThemeSelectedEvent extends AbstractEvent {

    public static final String TYPE = ThemeSelectedEvent.class.getName();

    @Override
    protected void fire(EventObserver eventObserver) {

    }

    @Override
    public String getType() {
        return null;
    }
}
