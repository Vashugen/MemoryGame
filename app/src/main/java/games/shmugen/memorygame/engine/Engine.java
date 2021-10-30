package games.shmugen.memorygame.engine;

import android.os.Handler;

import games.shmugen.memorygame.common.Shared;
import games.shmugen.memorygame.events.EventObserveAdapter;
import games.shmugen.memorygame.events.ui.ResetBackgroundEvent;

public class Engine extends EventObserveAdapter {

    private static Engine mInstance = null;
    private ScreenController mScreenController;
    private Handler mHandler;

    public Engine() {
        mScreenController = ScreenController.getInstance();
        mHandler = new Handler();
    }

    public static Engine getInstance(){
        if(mInstance == null){
            mInstance = new Engine();
        }

        return mInstance;
    }

    public void start(){

        Shared.eventBus.listen(ResetBackgroundEvent.TYPE, this);
    }

}
