package com.example.tangxb.myapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by Tangxb on 2016/3/9.
 */
public class MCommonViewHolder extends MBaseViewHolder {
    public LinearLayout linearLayout;
    public ImageView imageView;

    public MCommonViewHolder(View itemView) {
        super(itemView);
        linearLayout = (LinearLayout) itemView.findViewById(R.id.ll_common);
        imageView = (ImageView) itemView.findViewById(R.id.iv_item);
    }

    @Override
    public void animateImage() {

    }

}
