package games.shmugen.memorygame.events.ui;

import games.shmugen.memorygame.events.AbstractEvent;
import games.shmugen.memorygame.events.EventObserver;
import games.shmugen.memorygame.themes.Theme;

public class ThemeSelectedEvent extends AbstractEvent {

    public static final String TYPE = ThemeSelectedEvent.class.getName();
    public final Theme theme;

    public ThemeSelectedEvent(Theme theme) {
        this.theme = theme;
    }

    @Override
    protected void fire(EventObserver eventObserver) {
        eventObserver.onEvent(this);
    }

    @Override
    public String getType() {
        return null;
    }
}
