package games.shmugen.memorygame.events;

import games.shmugen.memorygame.events.ui.ResetBackgroundEvent;

public class EventObserveAdapter implements EventObserver{
    @Override
    public void onEvent(ResetBackgroundEvent event) {
        throw new UnsupportedOperationException();
    }
}
