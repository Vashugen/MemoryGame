package games.shmugen.memorygame.engine;

public class ScreenController {

    private static ScreenController mInstance = null;

    public static ScreenController getInstance(){
        if(mInstance == null){
            mInstance = new ScreenController();
        }

        return mInstance;
    }

}
