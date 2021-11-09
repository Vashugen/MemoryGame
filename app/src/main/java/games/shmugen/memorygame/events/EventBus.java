package games.shmugen.memorygame.events;

import android.animation.ObjectAnimator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import games.shmugen.memorygame.events.ui.StartEvent;

public class EventBus {

    private static EventBus mInstance = null;
    private final Map<String, List<EventObserver>> events = Collections.synchronizedMap(new HashMap<String, List<EventObserver>>());
    private Object obj = new Object();

    public static EventBus getInstance(){
        if(mInstance == null){
            mInstance = new EventBus();
        }

        return mInstance;
    }

    synchronized public void listen(String eventType, EventObserver eventObserver){

        List<EventObserver> observers = events.get(eventType);
        if (observers == null){
            observers = Collections.synchronizedList(new ArrayList<EventObserver>());
        }
        observers.add(eventObserver);
        events.put(eventType, observers);


    }

    public void notify(Event event) {
        synchronized (obj){
            List<EventObserver> observers = events.get(event.getType());
            if(observers != null){
                for (EventObserver observer: observers) {
                    AbstractEvent abstractEvent = (AbstractEvent) event;
                    abstractEvent.fire(observer);
                }
            }
        }
    }
}
