package com.android.tools;

import android.graphics.Bitmap;
import android.graphics.Matrix;

/**
 * Class for work with image, rather resize it.
 *
 * Created by Fujibayashi on 01.07.2015.
 */

public class ImageFactory {

    /**
     * Method resize Bitmap into new dimension(width * height)
     * @param bm Bitmap which contain image
     * @param newHeight Integer value. We need it to new height size of image
     * @param newWidth Integer value, needed for new width size of image
     * @return resizedBitmap Bitmap with new image(width * height)
     */
    public static Bitmap getResizedBitmap(Bitmap bm, int newHeight, int newWidth) {
        int width = bm.getWidth();
        int height = bm.getHeight();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;

        /* CREATE A MATRIX FOR THE MANIPULATION */
        Matrix matrix = new Matrix();

        /* RESIZE THE BIT MAP */
        matrix.postScale(scaleWidth, scaleHeight);

        /* "RECREATE" THE NEW BITMAP */
        Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, false);
        return resizedBitmap;
    }
}
