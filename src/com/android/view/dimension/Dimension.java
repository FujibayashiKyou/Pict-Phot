package com.android.view.dimension;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
    This class get dimension of current android device
 * Created by Fujibayashi on 29.06.2015.
 */
public class Dimension {
    /**
     * Constructor #1
     * @param height A int value to get size of object
     * @param width A int value to get size of object
     */
    public Dimension(int width, int height) {
        this.mHeight = height;
        this.mWidth = width;
    }

    /**
     * Constructor #2
     */
    public Dimension() {
    }

    /**
     * Constructor #3
     * @param x X - start coordinate
     * @param y Y - start coordinate
     * @param width A int value to get size of object
     * @param height A int value to get size of object
     */
    public Dimension(float x, float y, int width, int height){
        mX = x;
        mY = y;
        mWidth = width;
        mHeight = height;
    }

    /* |========================================| */
    /* |              PUBLIC METHODS            | */
    /* |========================================| */

    /**
     * Get X coordinate
     * @return X - start coordinate
     */
    public float getX() {
        return mX;
    }

    /**
     * Set X - start coordinate
     * @param x Float value that means X - start coordinate  of object
     */
    public void setX(float x) {
        mX = x;
    }

    /**
     * Get Y - start coordinate
     * @return Float value that means Y - coordinate start of object
     */
    public float getY() {
        return mY;
    }

    /**
     * Set Y - start coordinate
     * @param y Float value that means Y - start coordinate  of object
     */
    public void setY(float y) {
        mY = y;
    }

    /**
     * Put height value into container
     * @param height Integer value that means the height of object
     */
    public void setHeight(int height) {
        this.mHeight = height;
    }

    /**
     * Method return height value from container
     * @return height Integer value, means Y - end coordinate
     */
    public int getHeight() {
        return mHeight;
    }

    /**
     * Put width value into container
     * @param width Integer value that means the width of object
     */
    public void setWidth(int width) {
        this.mWidth = width;
    }

    /**
     * Method return width value from container
     * @return width Integer  value, means X - end coordinate
     */
    public int getWidth() {
        return mWidth;
    }


    /**
     * @param pixels A value in px (pixels) unit
     * @param context Context to get resources and device specific display metrics
     * @return A float value to represent px equivalent to dp depending on device density
     */
    public static float updateDimensionPixels(float pixels, Context context){
        float dp = convertPixelsToDp(pixels, context);
        return convertDpToPixel(dp, context);
    }

    @Override
    public String toString(){
        StringBuilder out = new StringBuilder();
        out.append("X: " + getX())
                .append(", Y: " + getY())
                .append(", Width: " + getWidth())
                .append(", Height: " + getHeight());

        return out.toString();
    }

    /* |========================================| */
    /* |             PRIVATE METHODS            | */
    /* |========================================| */

    /**
     * This method converts dp unit to equivalent pixels, depending on device density.
     *
     * @param dp A value in dp (density independent pixels) unit. Which we need to convert into pixels
     * @param context Context to get resources and device specific display metrics
     * @return A float value to represent px equivalent to dp depending on device density
     */
    private static float convertDpToPixel(float dp, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return px;
    }

    /**
     * This method converts device specific pixels to density independent pixels.
     *
     * @param px A value in px (pixels) unit. Which we need to convert into db
     * @param context Context to get resources and device specific display metrics
     * @return A float value to represent dp equivalent to px value
     */
    private static float convertPixelsToDp(float px, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float dp = px / (metrics.densityDpi / 160f);
        return dp;
    }


    /* ==================    VALUES    ================== */

    /* X and Y coordinates */
    private  float mX;
    private float mY;

    /* Width and Height */
    private int mHeight;
    private int mWidth;
}
