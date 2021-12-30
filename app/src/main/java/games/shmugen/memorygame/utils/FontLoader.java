package games.shmugen.memorygame.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.util.SparseArray;
import android.widget.TextView;

public class FontLoader {

    public static final int GROBOLD = 0;

    private static SparseArray<Typeface> fonts = new SparseArray<>();
    private static boolean fontsLoaded = false;

    public enum Font {
        GROBOLD(FontLoader.GROBOLD, "fonts/grobold.ttf");

        private int val;
        private String path;


        Font(int val, String path) {
            this.val = val;
            this.path = path;
        }

        public static String getByVal(int val){
            for (Font font: values()){
                if(font.val == val){
                    return font.path;
                }
            }
            return null;
        }
    }

    public static void setTypeFace(Context context, TextView[] textViews, Font font){

    }

    private static void setTypeFaceToTextViews(Context context, TextView[] textViews, Font font, int fontStyle)
    {

    }
}
