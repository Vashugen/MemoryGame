package games.shmugen.memorygame.events;

public abstract class AbstractEvent implements Event{

    protected abstract void fire(EventObserver eventObserver);

}
