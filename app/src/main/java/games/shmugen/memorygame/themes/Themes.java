package games.shmugen.memorygame.themes;

import android.graphics.Bitmap;

import java.util.ArrayList;

import games.shmugen.memorygame.common.Shared;
import games.shmugen.memorygame.utils.Utils;

public class Themes {

    public static String URL_DRAWABLE = "drawable://";

    public static Theme createAnimalsTheme(){
        Theme theme = new Theme();
        theme.id = 1;
        theme.name = "Animals";
        theme.backgroundImageUrl = URL_DRAWABLE + "back_animals";
        theme.titleImageUrls = new ArrayList<String>();
        //40 drawables
        for (int i = 1; i <= 28; i++) {
            theme.titleImageUrls.add(URL_DRAWABLE + String.format("animals_%d", i));
        }

        return theme;
    }

    public static Theme createMonstersTheme(){

        Theme theme = new Theme();
        theme.id = 2;
        theme.name = "Monsters";
        theme.backgroundImageUrl = URL_DRAWABLE + "back_horror";
        theme.titleImageUrls = new ArrayList<String>();
        //40 drawables
        for (int i = 1; i <= 40; i++) {
            theme.titleImageUrls.add(URL_DRAWABLE + String.format("monsters_%d", i));
        }

        return theme;

    }

    public static Theme createEmojiTheme(){

        Theme theme = new Theme();
        theme.id = 3;
        theme.name = "Emoji";
        theme.backgroundImageUrl = URL_DRAWABLE + "background";
        theme.titleImageUrls = new ArrayList<String>();
        //40 drawables
        for (int i = 1; i <= 40; i++) {
            theme.titleImageUrls.add(URL_DRAWABLE + String.format("emoji_%d", i));
        }

        return theme;

    }

    public static Bitmap getBackgroundImage(Theme theme){
        String drawableResourceName = theme.backgroundImageUrl.substring(Themes.URL_DRAWABLE.length());
        int drawableResourceId = Shared.context.getResources().getIdentifier(drawableResourceName, "drawable", Shared.context.getPackageName());
        Bitmap bitmap = Utils.scaleDown(drawableResourceId, Utils.screenWidth(), Utils.screenHeight());
        return bitmap;
    }
}
