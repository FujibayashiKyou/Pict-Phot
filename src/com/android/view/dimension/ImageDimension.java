package com.android.view.dimension;

/**
 * Created by Fujibayashi on 01.07.2015.
 */
public class ImageDimension extends Dimension {

    /**
     * Constructor #1
     */
    public ImageDimension(){}

    /**
     * Constructor #2
     * @param x
     * @param y
     */
    public ImageDimension(float x, float y) {
        mX = x;
        mY = y;
    }

    /**
     * Constructor #3
     * @param width
     * @param height
     */
    public ImageDimension(int width, int height){
        mWidth = width;
        mHeight = height;
    }

    /**
     * Contructor #4
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public ImageDimension(float x, float y, int width, int height){
        mX = x;
        mY = y;
        mWidth = width;
        mHeight = height;
    }


    /* ==================    VALUES    ==================*/
    private  float mX;
    private float mY;

    private int mHeight;
    private int mWidth;
}
