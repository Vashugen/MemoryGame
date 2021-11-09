package games.shmugen.memorygame.events;

import games.shmugen.memorygame.events.ui.DifficultySelectedEvent;
import games.shmugen.memorygame.events.ui.FlipCardEvent;
import games.shmugen.memorygame.events.ui.ResetBackgroundEvent;

public interface EventObserver {

    void onEvent(ResetBackgroundEvent event);
    void onEvent(FlipCardEvent event);
    void onEvent(DifficultySelectedEvent event);
    void onEvent( event);
    void onEvent(ResetBackgroundEvent event);
    void onEvent(ResetBackgroundEvent event);
    void onEvent(ResetBackgroundEvent event);
    void onEvent(ResetBackgroundEvent event);
    void onEvent(ResetBackgroundEvent event);

}
