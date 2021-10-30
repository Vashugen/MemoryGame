package games.shmugen.memorygame.events;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EventBus {

    private static EventBus mInstance = null;
    private final Map<String, List<EventObserver>> events = Collections.synchronizedMap(new HashMap<String, List<EventObserver>>());

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

}
