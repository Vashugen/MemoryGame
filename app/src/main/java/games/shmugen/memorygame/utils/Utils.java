package games.shmugen.memorygame.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import games.shmugen.memorygame.common.Shared;

public class Utils {

    public static Bitmap scaleDown(int resource, int reqWidth, int reqHeight){

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        return BitmapFactory.decodeResource(Shared.context.getResources(), resource);

        //options.inSampleSize =


    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight){

        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if(height > reqHeight || width > reqWidth){
            final int heightRatio = Math.round((float) height / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);

            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;

        }

        return inSampleSize;

    }

}
