package com.example.tangxb.myapplication;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.List;

/**
 * Created by Tangxb on 2016/3/9.
 */
public class MyCommonAdapter extends MBaseAdapter<String> {

    public MyCommonAdapter(Context context) {
        super(context);
    }

    @Override
    public MBaseViewHolder createViewHolder(View view) {
        return new MCommonViewHolder(view);
    }

    @Override
    public View createView(ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) viewGroup.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.layout_common_list_item, viewGroup, false);
        return view;
    }

    public void testMutilHeight(int position, StaggeredGridLayoutManager.LayoutParams layoutParams) {
        if (position % 3 == 0) {
            layoutParams.height = DensityUtils.dp2px(mBaseContext, 200);
        } else if (position % 3 == 1) {
            layoutParams.height = DensityUtils.dp2px(mBaseContext, 250);
        } else if (position % 3 == 2) {
            layoutParams.height = DensityUtils.dp2px(mBaseContext, 300);
        }
    }

    public void testGrid(int position, GridLayoutManager.LayoutParams layoutParams) {
        layoutParams.height = DensityUtils.dp2px(mBaseContext, 200);
    }

    @Override
    public void showData(MBaseViewHolder holder2, int position, List<String> list) {
        // please set imageView scaleType,so important
        String url = list.get(position);
        MCommonViewHolder holder = (MCommonViewHolder) holder2;
        ViewGroup.LayoutParams layoutParams = holder.linearLayout.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            testMutilHeight(position, (StaggeredGridLayoutManager.LayoutParams) layoutParams);
        } else if (layoutParams instanceof GridLayoutManager.LayoutParams) {
            testGrid(position, (GridLayoutManager.LayoutParams) layoutParams);
            holder.linearLayout.setLayoutParams(layoutParams);
        }
        MyGlideUtils.loadImgByUrlCommon(mBaseContext, url, holder.imageView);
    }
}
