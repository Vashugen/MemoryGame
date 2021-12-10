package games.shmugen.memorygame.common;

import android.content.Context;
import android.content.SharedPreferences;

public class Memory {

    private static final String SHARED_PREFERENCES_NAME = "games.shmugen.memorygame";
    private static String highStartKey = "theme_%d_dificulty_%d";
    private static String bestTimeKey = "themetime_%d_dificultytime_%d";

    public static int getHighClass(int theme, int diffuclty){
        SharedPreferences sharedPreferences = Shared.context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        String key = String.format(highStartKey, theme, diffuclty);
        return sharedPreferences.getInt(key, 0);
    }

}
