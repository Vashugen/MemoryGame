package games.shmugen.memorygame.engine;

import android.os.Handler;
import android.widget.ImageView;

import games.shmugen.memorygame.common.Shared;
import games.shmugen.memorygame.events.EventObserveAdapter;
import games.shmugen.memorygame.events.ui.BackGameEvent;
import games.shmugen.memorygame.events.ui.DifficultySelectedEvent;
import games.shmugen.memorygame.events.ui.FlipCardEvent;
import games.shmugen.memorygame.events.ui.NextGameEvent;
import games.shmugen.memorygame.events.ui.ResetBackgroundEvent;
import games.shmugen.memorygame.events.ui.StartEvent;
import games.shmugen.memorygame.events.ui.ThemeSelectedEvent;

public class Engine extends EventObserveAdapter {

    private static Engine mInstance = null;
    private ScreenController mScreenController;
    private Handler mHandler;
    private ImageView mBackgroundImage;

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
        Shared.eventBus.listen(FlipCardEvent.TYPE, this);
        Shared.eventBus.listen(StartEvent.TYPE, this);
        Shared.eventBus.listen(DifficultySelectedEvent.TYPE, this);
        Shared.eventBus.listen(ThemeSelectedEvent.TYPE, this);
        Shared.eventBus.listen(BackGameEvent.TYPE, this);
        Shared.eventBus.listen(NextGameEvent.TYPE, this);
    }

    public void setBackgroundImageView(ImageView backgroundImage){
        mBackgroundImage = backgroundImage;
    }

}
