package com.example.tangxb.myapplication;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Tangxb on 2016/3/9.
 */
public class ParallaxImageView extends ImageView {
    private ParallaxImageListener listener;
    private final float DEFAULT_PARALLAX_RATIO = 2.5f;
    private float parallaxRatio = DEFAULT_PARALLAX_RATIO;
    private boolean needToTranslate = true;

    private int rowHeight = -1;
    private int rowYPos = -1;
    private int recyclerViewHeight = -1;
    private int recyclerViewYPos = -1;

    public interface ParallaxImageListener {
        int[] requireValuesForTranslate();

        int getItemNeedActH();
    }

    public ParallaxImageView(Context context) {
        this(context, null);
    }

    public ParallaxImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ParallaxImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setScaleType(ScaleType.MATRIX);
    }

    public ParallaxImageListener getListener() {
        return listener;
    }

    public void setListener(ParallaxImageListener listener) {
        this.listener = listener;
    }

    /**
     * This trick was needed because there is no way to detect when image is displayed,
     * we need to translate image for very first time as well. This will be needed only
     * if you are using async image loading...
     * <p/>
     * # If only there was another way to get notified when image has displayed.
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        if (needToTranslate) {
            needToTranslate = !doTranslate();
        }
    }

    /**
     * Notify this view when it is back on recyclerView, so we can reset.
     */
    public void reuse() {
        needToTranslate = true;
    }

    public synchronized boolean doTranslate() {
        if (getDrawable() == null) {
            return false;
        }
        if (getListener() != null) {
            getValues();
            calculateAndMove();
        } else {
            return false;
        }

        return true;
    }

    private void getValues() {
        int[] values = getListener().requireValuesForTranslate();
        this.rowHeight = values[0];
        this.rowYPos = values[1];
        this.recyclerViewHeight = values[2];
        this.recyclerViewYPos = values[3];
    }

    private void calculateAndMove() {
        float distanceFromCenter = (recyclerViewYPos + recyclerViewHeight) / 2 - rowYPos;
        // if glide or picasso used placeholder , getIntrinsicHeight it's not the really need actually height
        // so i used getItemNeedActH
//        int imageHeight = getDrawable().getIntrinsicHeight();
        int imageHeight = getListener().getItemNeedActH();
        float difference = imageHeight - rowHeight;
        float move = (distanceFromCenter / recyclerViewHeight) * difference * parallaxRatio;

        moveTo((move / 2) - (difference / 2));
    }

    private void moveTo(float move) {
        Matrix imageMatrix = getImageMatrix();
        float[] matrixValues = new float[9];
        imageMatrix.getValues(matrixValues);
        float current = matrixValues[Matrix.MTRANS_Y];
        imageMatrix.postTranslate(0, move - current);
        setImageMatrix(imageMatrix);
        invalidate();
    }

}
