package games.shmugen.memorygame.events;

import games.shmugen.memorygame.events.engine.FlipDownCardsEvent;
import games.shmugen.memorygame.events.engine.HidePairCardsEvent;
import games.shmugen.memorygame.events.ui.BackGameEvent;
import games.shmugen.memorygame.events.ui.DifficultySelectedEvent;
import games.shmugen.memorygame.events.ui.FlipCardEvent;
import games.shmugen.memorygame.events.ui.NextGameEvent;
import games.shmugen.memorygame.events.ui.ResetBackgroundEvent;
import games.shmugen.memorygame.events.ui.StartEvent;
import games.shmugen.memorygame.events.ui.ThemeSelectedEvent;

public interface EventObserver {

    void onEvent(ResetBackgroundEvent event);

    void onEvent(FlipCardEvent event);

    void onEvent(DifficultySelectedEvent event);

    void onEvent(HidePairCardsEvent event);

    void onEvent(FlipDownCardsEvent event);

    void onEvent(StartEvent event);

    void onEvent(ThemeSelectedEvent event);

    void onEvent(BackGameEvent event);

    void onEvent(NextGameEvent event);

}
