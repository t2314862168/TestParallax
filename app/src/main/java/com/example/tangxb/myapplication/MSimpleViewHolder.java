package com.example.tangxb.myapplication;

import android.view.View;

/**
 * Created by Tangxb on 2016/3/9.
 */
public class MSimpleViewHolder extends MBaseViewHolder implements ParallaxImageView.ParallaxImageListener {
    public ParallaxImageView imageView;

    public MSimpleViewHolder(View itemView) {
        super(itemView);
        imageView = (ParallaxImageView) itemView.findViewById(R.id.iv_item);
        imageView.setListener(this);
    }

    public ParallaxImageView getBackgroundImage() {
        return imageView;
    }

    @Override
    public void animateImage() {
        getBackgroundImage().doTranslate();
    }

    @Override
    public int[] requireValuesForTranslate() {
        int[] itemPosition = new int[2];
        itemView.getLocationOnScreen(itemPosition);

        int[] recyclerPosition = new int[2];
        ((View) itemView.getParent()).getLocationOnScreen(recyclerPosition);

        return new int[]{itemView.getMeasuredHeight(), itemPosition[1], ((View) itemView.getParent()).getMeasuredHeight(), recyclerPosition[1]};
    }

    @Override
    public int getItemNeedActH() {
        // image measured height add need extra height
        return itemView.getMeasuredHeight() + DensityUtils.dp2px(itemView.getContext(), 100);
    }
}
