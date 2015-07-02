package com.android.view.screen;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.android.tools.ImageFactory;
import com.android.view.dimension.Dimension;
import com.android.view.dimension.ImageDimension;
import com.android.view.ext.R;

/**
 * Created by Fujibayashi on 01.07.2015.
 */
public class Photo extends ImageView implements PhotoBorderMargin {
    /**
     * Constructor #1
     * @param context
     */
    public Photo(Context context) {
        super(context);
        this._context = context;

        imDimension = new ImageDimension();
    }

    /* |========================================| */
    /* |              PUBLIC METHODS            | */
    /* |========================================| */

    /**
     * Get link of ImageView which contain some params for correct view on the screen
     * @return ImageView with params
     */
    public ImageView getPhoto() {
        /* Set params to ImageView and return it link */
        setParamsToImageView();
        return mPhoto;
    }

    /**
     * Get ImageView link from MainActivity
     * @param photo ImageView ID which we create in MainActivity
     * @param parent FrameLayout, which contain ImageView. We need it for correct size of ImageView
     */
    public void setPhoto(ImageView photo, FrameLayout parent) {
        mPhoto = photo;
        mParent = parent;
    }

    /**
     * Draw
     */
    public static void drawImage(){
        seekAreaForDraw();

        /* Draw image */
        mPhoto.setImageResource(R.drawable.test_image);
        Bitmap bitmap = mPhoto.getDrawingCache(true);
        BitmapDrawable drawable = (BitmapDrawable) mPhoto.getDrawable();
        bitmap = drawable.getBitmap();

        Bitmap resizedBitmap = ImageFactory.getResizedBitmap(
                bitmap,
                imDimension.getHeight(),
                imDimension.getWidth()
        );

        mPhoto.setImageBitmap(resizedBitmap);
    }

    /* |========================================| */
    /* |             PRIVATE METHODS            | */
    /* |========================================| */

    /* Seek draw area on the PhotoBorder */
    private static void seekAreaForDraw(){
        /* X - start coordinate */
        imDimension.setX(Dimension.updateDimensionPixels(
                MARGIN_LEFT,
                _context)
        );

        /* Y - start coordinate */
        imDimension.setY(Dimension.updateDimensionPixels(
                MARGIN_TOP,
                _context)
        );

        /* X - end coordinate */
        imDimension.setWidth( (int) (0.5f + Dimension.updateDimensionPixels(
                (mParent.getWidth() - MARGIN_RIGHT),
                _context))
        );

        /* Y - end coordinate */
        imDimension.setHeight((int) (0.5f + Dimension.updateDimensionPixels(
                (mParent.getHeight() - MARGIN_BOTTOM),
                _context))
        );
    }

    /**
     * Set to ImageView container params.
     * This method is need for correct position on the screen
     */
    private void setParamsToImageView() {
        mPhoto.setX(imDimension.getX());
        mPhoto.setY(imDimension.getY());
        mPhoto.setMaxWidth(imDimension.getWidth());
        mPhoto.setMaxHeight(imDimension.getHeight());
        mPhoto.setAdjustViewBounds(true);
    }


    /* ============== VALUES ============== */
    /* Context need for get dimension of the screen */
    private static Context _context;

    private static ImageView mPhoto;
    private static FrameLayout mParent;

    private static ImageDimension imDimension;
}
