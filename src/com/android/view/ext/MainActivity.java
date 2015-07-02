/*
    * @(#) MainActivity.java          2015/06/29
    *
    * Copyright 2015-2016 Ivan Zamurenko (FujibayashiKyou)
    * Kylisha 15b, Shumenskiy, Kherson, Ukraine
    * All rights reserved
    *
    * This software is the confidential and proprietary information of
    * Zamurenko Ivan. ("Confidential Information"). You shall not
    * disclose such Confidential Information and shall use it only in
    * accordance with the terms of the license agreement you entered with me.
 */

package com.android.view.ext;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.android.view.dimension.PhotoBorderDimension;
import com.android.view.screen.Photo;
import com.android.view.screen.PhotoBorder;

/**
 *
        This class show main activity on the device and contains this components:
    1) ImageView with custom picture/photo
    2) ImageView - background for picture/photo
    3) SatelliteMenu - popup buttons
 *
 * @version 1.0
            29 Jun 2015 * @author
            Ivan Zamurenko
 */

public class MainActivity extends Activity {

    /* Called when the activity is first created */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mForegroundContainer = (FrameLayout) findViewById(R.id.fl_foreground_bg);
        mForegroundImage = (ImageView) findViewById(R.id.iv_foreground);
        mBackgroundContainer = (FrameLayout) findViewById(R.id.fl_background_bg);
        mBackgroundImage = (ImageView) findViewById(R.id.iv_background);

        /* Draw two photo frame on the screen */
        drawPhotoBorders();
    }

    /**
     * Method draw two photo frames on the screen
     */
    private void drawPhotoBorders(){

        /* Draw photoBorder for foreground picture */
        mForegroundPhotoBorder = new PhotoBorder(this, Gravity.TOP | Gravity.LEFT, -14.0f);
        mForegroundPhotoBorder.setPhotoFrame(mForegroundContainer);
        mForegroundPhotoBorder.drawPhotoFrame();
        mForegroundContainer = mForegroundPhotoBorder.getPhotoFrame();

        mForegroundContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*  Container need for input X and Y coordinates in to container*/
                PhotoBorderDimension container = mForegroundPhotoBorder.getPhotoBorderDimension();

                /* Save X and Y coordinates in to container class: PhotoBorderDimension */
                container.setX(mForegroundContainer.getX());
                container.setY(mForegroundContainer.getY());

                /* Image view draw */
                Photo mForegroundPhoto = new Photo(getApplicationContext());
                mForegroundPhoto.setPhoto(mForegroundImage, mForegroundContainer);
                mForegroundPhoto.drawImage();
                mForegroundImage = mForegroundPhoto.getPhoto();
            }
        });

        /* Draw photoBorder for background picture */
        mBackgroundPhotoBorder = new PhotoBorder(this, Gravity.BOTTOM | Gravity.RIGHT, 20.0f);
        mBackgroundPhotoBorder.setPhotoFrame(mBackgroundContainer);
        mBackgroundPhotoBorder.drawPhotoFrame();
        mBackgroundContainer = mBackgroundPhotoBorder.getPhotoFrame();

        mBackgroundContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*  Container need for input X and Y coordinates in to container*/
                PhotoBorderDimension container = mBackgroundPhotoBorder.getPhotoBorderDimension();

                /* Save X and Y coordinates in to container class: ObjectDimension */
                container.setX(mBackgroundContainer.getX());
                container.setY(mBackgroundContainer.getY());

                /* Image view draw */
                Photo mBackgroundPhoto = new Photo(getApplicationContext());
                mBackgroundPhoto.setPhoto(mBackgroundImage, mBackgroundContainer);
                mBackgroundPhoto.drawImage();
                mBackgroundImage = mBackgroundPhoto.getPhoto();
            }
        });
    }


    /* ==================    VALUES    ================== */

    /* ImageView components */
    private ImageView mForegroundImage;
    private ImageView mBackgroundImage;

    /* FrameLayout components */
    private FrameLayout mForegroundContainer;
    private FrameLayout mBackgroundContainer;

    /* FrameLayout params container */
    private PhotoBorder mForegroundPhotoBorder;
    private PhotoBorder mBackgroundPhotoBorder;

    /* Log */
    private static final String LOG = "myLog";
}
