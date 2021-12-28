package games.shmugen.memorygame.engine;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.AsyncTask;
import android.os.Handler;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import games.shmugen.memorygame.R;
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
import games.shmugen.memorygame.model.BoardArrangment;
import games.shmugen.memorygame.model.BoardConfiguration;
import games.shmugen.memorygame.model.Game;
import games.shmugen.memorygame.themes.Theme;
import games.shmugen.memorygame.themes.Themes;
import games.shmugen.memorygame.utils.Utils;

public class Engine extends EventObserveAdapter {

    private static Engine mInstance = null;
    private ScreenController mScreenController;
    private Handler mHandler;
    private ImageView mBackgroundImage;
    private Theme mSelectedTheme;
    private int mFlippedId = -1;
    private Game mPlayingGame = null;
    private int mToFlip = -1;

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
        mFlippedId = -1;
        mPlayingGame = new Game();
        mPlayingGame.boardConfiguration = new BoardConfiguration(event.difficulty);
        mPlayingGame.theme = mSelectedTheme;
        mToFlip = mPlayingGame.boardConfiguration.numTiles;

        arrangeBoard();

        mScreenController.openScreen(ScreenController.Screen.GAME);
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
        mScreenController.openScreen(ScreenController.Screen.DIFFICULTY);

        AsyncTask<Void, Void, TransitionDrawable> task = new AsyncTask<Void, Void, TransitionDrawable>() {
            @Override
            protected TransitionDrawable doInBackground(Void... params) {
                Bitmap bitmap = Utils.scaleDown(R.drawable.background, Utils.screenWidth(), Utils.screenHeight());
                Bitmap backgroundImage = Themes.getBackgroundImage(mSelectedTheme);
                backgroundImage = Utils.crop(backgroundImage, Utils.screenHeight(), Utils.screenWidth());

                Drawable backgrounds[] = new Drawable[2];
                backgrounds[0] = new BitmapDrawable(Shared.context.getResources(), bitmap);
                backgrounds[1] = new BitmapDrawable(Shared.context.getResources(), backgroundImage);
                TransitionDrawable crossfader = new TransitionDrawable(backgrounds);
                return crossfader;
            }

            @Override
            protected void onPostExecute(TransitionDrawable result) {
                super.onPostExecute(result);
                mBackgroundImage.setImageDrawable(result);
                result.startTransition(2000);
            }
        };

        task.execute();
    }

    @Override
    public void onEvent(BackGameEvent event) {
        super.onEvent(event);
    }

    @Override
    public void onEvent(NextGameEvent event) {
        super.onEvent(event);
    }

    public Theme getSelectedTheme(){
        return mSelectedTheme;
    }

    private void arrangeBoard(){
        BoardConfiguration boardConfiguration = mPlayingGame.boardConfiguration;
        BoardArrangment boardArrangment = new BoardArrangment();

        List<Integer> ids = new ArrayList<>();
        for (int i = 0; i < boardConfiguration.numTiles; i++){
            ids.add(i);
        }

        Collections.shuffle(ids);

        //place the board
        List<String> titleImageUrls = mPlayingGame.theme.titleImageUrls;
        Collections.shuffle(titleImageUrls);

        boardArrangment.pairs = new HashMap<Integer, Integer>();
        boardArrangment.tileUrls = new HashMap<Integer, String>();

        int j = 0;
        for (int i = 0; i < ids.size(); i ++){
            if(i + 1 < ids.size()){
                boardArrangment.pairs.put(ids.get(i), ids.get(i+1));
                boardArrangment.pairs.put(ids.get(i+1), ids.get(i));
                boardArrangment.tileUrls.put(ids.get(i), titleImageUrls.get(j));
                boardArrangment.tileUrls.put(ids.get(i+1), titleImageUrls.get(j));
                i++;
                j++;
            }
        }

        mPlayingGame.boardArrangment = boardArrangment;
    }
}
