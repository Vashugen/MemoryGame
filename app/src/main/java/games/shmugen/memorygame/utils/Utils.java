package games.shmugen.memorygame.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.media.ThumbnailUtils;

import games.shmugen.memorygame.common.Shared;

public class Utils {

    public static int screenWidth(){
        return Shared.context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int screenHeight(){
        return Shared.context.getResources().getDisplayMetrics().heightPixels;
    }

    public static Bitmap scaleDown(int resource, int reqWidth, int reqHeight){

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(Shared.context.getResources(), resource);

        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(Shared.context.getResources(), resource, options);

    }

    public static Bitmap crop(Bitmap source, int newHeight, int newWidth){

        int sourceWidth = source.getWidth();
        int sourceHeight = source.getHeight();

        float xScale = (float) newWidth / sourceWidth;
        float yScale = (float) newHeight / sourceHeight;
        float scale = Math.max(xScale, yScale);

        float scaleWidth = scale * sourceWidth;
        float scaleHeight = scale * sourceHeight;

        float left = (newWidth - scaleWidth) / 2;
        float top = (newHeight - scaleHeight) / 2;

        RectF targetRect = new RectF(left, top, left + scaleWidth, top + scaleHeight);

        Bitmap dest = Bitmap.createBitmap(newWidth, newHeight, source.getConfig());
        Canvas canvas = new Canvas(dest);
        canvas.drawBitmap(source, null, targetRect, null);

        return dest;

    }

    public static Bitmap downscaleBitmap(Bitmap wallpaper, int factor){

        int widthPixels = wallpaper.getWidth() / factor;
        int heightPixels = wallpaper.getHeight() / factor;

        return ThumbnailUtils.extractThumbnail(wallpaper, widthPixels, heightPixels);

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
