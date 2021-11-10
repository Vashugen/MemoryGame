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

public class EventObserveAdapter implements EventObserver{
    @Override
    public void onEvent(ResetBackgroundEvent event) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void onEvent(FlipCardEvent event) {

    }

    @Override
    public void onEvent(DifficultySelectedEvent event) {

    }

    @Override
    public void onEvent(HidePairCardsEvent event) {

    }

    @Override
    public void onEvent(FlipDownCardsEvent event) {

    }

    @Override
    public void onEvent(StartEvent event) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void onEvent(ThemeSelectedEvent event) {

    }

    @Override
    public void onEvent(BackGameEvent event) {

    }

    @Override
    public void onEvent(NextGameEvent event) {

    }
}
