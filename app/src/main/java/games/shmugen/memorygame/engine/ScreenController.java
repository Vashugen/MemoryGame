package games.shmugen.memorygame.engine;

import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;

import games.shmugen.memorygame.R;
import games.shmugen.memorygame.common.Shared;
import games.shmugen.memorygame.events.ui.ThemeSelectedEvent;
//import games.shmugen.memorygame.fragments.GameFragment;
import games.shmugen.memorygame.fragments.MenuFragment;

public class ScreenController {

    private static ScreenController mInstance = null;
    private FragmentManager mFragmentManager;
    private static List<Screen> openedScreens = new ArrayList<>();

    public enum Screen {
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
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
        openedScreens.add(screen);
    }

    private Fragment getFragment(Screen screen){
        switch (screen){
            case MENU:
                return new MenuFragment();
            case DIFFICULTY:

                break;

            case THEME_SELECT:
                return new ThemeSelectFragment();

            case GAME:
                //return new GameFragment();
        }
        return new Fragment();
    }

}
