package games.shmugen.memorygame.engine;

import android.os.Handler;
import android.widget.ImageView;

import games.shmugen.memorygame.common.Shared;
import games.shmugen.memorygame.events.EventObserveAdapter;
import games.shmugen.memorygame.events.engine.FlipDownCardsEvent;
import games.shmugen.memorygame.events.engine.HidePairCardsEvent;
import games.shmugen.memorygame.events.ui.BackGameEvent;
import games.shmugen.memorygame.events.ui.DifficultySelectedEvent;
import games.shmugen.memorygame.events.ui.FlipCardEvent;
import games.shmugen.memorygame.events.ui.NextGameEvent;
import games.shmugen.memorygame.events.ui.ResetBackgroundEvent;
import games.shmugen.memorygame.events.ui.StartEvent;
import games.shmugen.memorygame.events.ui.ThemeSelectedEvent;
import games.shmugen.memorygame.themes.Theme;

public class Engine extends EventObserveAdapter {

    private static Engine mInstance = null;
    private ScreenController mScreenController;
    private Handler mHandler;
    private ImageView mBackgroundImage;
    private Theme mSelectedTheme;

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

    @Override
    public void onEvent(StartEvent event) {
        mScreenController.openScreen(ScreenController.Screen.THEME_SELECT);
    }

    @Override
    public void onEvent(ResetBackgroundEvent event) {
        super.onEvent(event);
    }

    @Override
    public void onEvent(FlipCardEvent event) {
        super.onEvent(event);
    }

    @Override
    public void onEvent(DifficultySelectedEvent event) {
        super.onEvent(event);
    }

    @Override
    public void onEvent(HidePairCardsEvent event) {
        super.onEvent(event);
    }

    @Override
    public void onEvent(FlipDownCardsEvent event) {
        super.onEvent(event);
    }

    @Override
    public void onEvent(ThemeSelectedEvent event) {
        mSelectedTheme = event.theme;
    }

    @Override
    public void onEvent(BackGameEvent event) {
        super.onEvent(event);
    }

    @Override
    public void onEvent(NextGameEvent event) {
        super.onEvent(event);
    }
}
