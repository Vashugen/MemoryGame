package games.shmugen.memorygame.events;

import games.shmugen.memorygame.events.ui.ResetBackgroundEvent;

public interface EventObserver {

    void onEvent(ResetBackgroundEvent event);

}
