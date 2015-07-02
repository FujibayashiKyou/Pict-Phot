package com.android.view.screen;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.widget.FrameLayout;
import com.android.view.dimension.Dimension;
import com.android.view.dimension.PhotoBorderDimension;
import com.android.view.ext.R;

/**
 * Created by Fujibayashi on 30.06.2015.
 */
public class PhotoBorder extends FrameLayout {
    /**
     *
     * @param context
     * @param gravity
     * @param rotationDegree
     */
    public PhotoBorder(Context context, int gravity, float rotationDegree) {
        super(context);
        _context = context;
        mGravity = gravity;
        mDegree = rotationDegree;
    }

    /* |========================================| */
    /* |              PUBLIC METHODS            | */
    /* |========================================| */

    /**
     * Get FrameLayout - object link for work with it
     * @param photoFrame FrameLayout object
     */
    public void setPhotoFrame(FrameLayout photoFrame) {
        mPhotoFrame = photoFrame;
    }

    /**
     * Return modify FrameLayout object
     * @return FrameLayout object with some params
     */
    public FrameLayout getPhotoFrame(){
        return mPhotoFrame;
    }

    /**
     * Draw FrameLayout on the device`s screen.
     * Draw photo frame with black background
     */
    public void drawPhotoFrame(){
        setParamsForFrameLayout();
    }

    /**
     * Get FrameLayout`s container with some params
     * @return mProperties This is PhotoBorderDimension
     *      class contain params for FrameLayout
     */
    public PhotoBorderDimension getPhotoBorderDimension(){
        return mProperties;
    }


    /* |========================================| */
    /* |             PRIVATE METHODS            | */
    /* |========================================| */

    /**
     * Method for set parameters proceeding device`s screen
     * @return
     */
    private void setParamsForFrameLayout(){
        /* Call setMetrixForFrameLayout for get metrix from android device */
        setMetrixForFrameLayout();
        int width = mProperties.getWidth();
        int height = mProperties.getHeight();

        /* Set layout mParams */
        mParams = new FrameLayout.LayoutParams(width, height);
        mParams.gravity = mGravity;
        mParams.setMargins(100, 100, 100, 100);

        /* Save layout params in ObjectDimension class */
        mProperties.setLayoutParams(mParams);
        mPhotoFrame.setLayoutParams(mProperties.getLayoutParams());

        /* Set background and foreground */
        mPhotoFrame.setBackgroundColor(getResources().getColor(R.color.myBlack));
        mPhotoFrame.setForeground(getResources().getDrawable(R.drawable.photo_border));

        /* Set rotation degree */
        mPhotoFrame.setRotation(mDegree);
    }


    /**
     * Method get dimension of android device.
     * From metrics FrameLayout receive width & height.
     * Init PhotoBorderDimension() - this is container for FrameLayout,
     *      which contain different params like:
     *          - width, height;
     *          - gravity;
     *          - margins;
     *          - rotation;
     *          - background & foreground
     */
    private void setMetrixForFrameLayout(){
         /* Get screen metrics */
        DisplayMetrics metrics = new DisplayMetrics();
        ((Activity) _context)
                .getWindowManager()
                .getDefaultDisplay()
                .getMetrics(metrics);

        int width = (int) (Dimension.updateDimensionPixels
                (metrics.widthPixels / 3,
                _context)
        );

        int height = (int) (Dimension.updateDimensionPixels
                (metrics.heightPixels / 4,
                _context)
        );

        /* Set coordinates into object`s values (Width, Height) */
        mProperties = new PhotoBorderDimension(
                width,
                height
        );
    }

    /* ============== VALUES ============== */
    private Context _context;

    /* Frame layout values */
    private FrameLayout mPhotoFrame;
    private FrameLayout.LayoutParams mParams;

    /* Need for see X, Y, Width, Height of element */
    private PhotoBorderDimension mProperties;

    /* Gravity value */
    private int mGravity;

    /* Degree for rotation */
    private float mDegree;
}
