package com.example.tangxb.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Tangxb on 2016/3/9.
 */
public abstract class MBaseViewHolder extends RecyclerView.ViewHolder {
    public MBaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void animateImage();
}
