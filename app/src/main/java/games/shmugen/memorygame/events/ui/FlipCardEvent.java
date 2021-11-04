package games.shmugen.memorygame.events.ui;

import games.shmugen.memorygame.events.AbstractEvent;
import games.shmugen.memorygame.events.EventObserver;

public class FlipCardEvent extends AbstractEvent {

    public static final String TYPE = FlipCardEvent.class.getName();

    @Override
    protected void fire(EventObserver eventObserver) {

    }

    @Override
    public String getType() {
        return null;
    }
}
