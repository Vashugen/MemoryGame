package games.shmugen.memorygame.engine;

import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;
import java.util.List;

import games.shmugen.memorygame.common.Shared;

public class ScreenController {

    private static ScreenController mInstance = null;
    private FragmentManager mFragmentManager;
    private static List<Screen> openedScreens = new ArrayList<>();

    public static enum Screen {
        MENU,
        GAME,
        DIFFICULTY,
        THEME_SELECT
    }

    public static ScreenController getInstance(){
        if(mInstance == null){
            mInstance = new ScreenController();
        }

        return mInstance;
    }

    public void openScreen(Screen screen){
        mFragmentManager = Shared.activity.getSupportFragmentManager();

        if(screen == Screen.GAME && openedScreens.get(openedScreens.size() - 1) == Screen.GAME){
            openedScreens.remove(openedScreens.size() - 1);
        }else if (screen == Screen.DIFFICULTY && openedScreens.get(openedScreens.size() - 1) == Screen.GAME) {
            openedScreens.remove(openedScreens.size() - 1);
            openedScreens.remove(openedScreens.size() - 1);
        }

        Fragment fragment = getFragment(screen);
    }

    private Fragment getFragment(Screen screen){
        switch (screen){
            case MENU:
                //return new Men
                break;

            case DIFFICULTY:

                break;
        }
        return new Fragment();
    }

}
