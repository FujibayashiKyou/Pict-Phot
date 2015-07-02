package com.android.view.dimension;

import android.widget.FrameLayout;

/**
 * Created by Fujibayashi on 01.07.2015.
 */
public class PhotoBorderDimension extends Dimension {
    /**
     * Constructor #1
     */
    public PhotoBorderDimension(){}

    /**
     * Constructor #2
     * @param width
     * @param height
     */
    public PhotoBorderDimension(int width, int height) {
        super(width, height);
        mWidth = width;
        mHeight = height;
    }

    /**
     * Constructor #3
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public PhotoBorderDimension(float x, float y, int width, int height) {
        super(x,y,width,height);
        mX = x;
        mY = y;
        mWidth = width;
        mHeight = height;
    }

    /**
     * Return FrameLayout.LayoutParams which contain params as:
     *      - width, height
     *      - gravity
     *      - margins
     *      - and other...
     * @return mParams LayoutParams
     */
    public FrameLayout.LayoutParams getLayoutParams() {
        return mParams;
    }

    /**
     * Put FrameLayout.LayoutParams into container
     * @param params FrameLayout.LayoutParams with some params
     */
    public void setLayoutParams(FrameLayout.LayoutParams params) {
        mParams = params;
    }

    /* ==================    VALUES    ================== */

    /* X and Y coordinates */
    private  float mX;
    private float mY;

    /* Width and Height */
    private int mHeight;
    private int mWidth;

    /* Some params for FrameLayout */
    private FrameLayout.LayoutParams mParams;
}
