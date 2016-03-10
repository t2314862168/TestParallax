package com.example.tangxb.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Tangxb on 2016/3/9.
 */
public class MySimpleAdapter extends MBaseAdapter<String> {

    public MySimpleAdapter(Context context) {
        super(context);
    }

    @Override
    public MBaseViewHolder createViewHolder(View view) {
        return new MSimpleViewHolder(view);
    }

    @Override
    public View createView(ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) viewGroup.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.layout_list_item, viewGroup, false);
        return view;
    }

    @Override
    public void showData(MBaseViewHolder holder2, int position, List<String> list) {
        String url = list.get(position);
        MSimpleViewHolder holder = (MSimpleViewHolder) holder2;
        MyGlideUtils.loadImgByUrl(mBaseContext, url, holder.imageView);
        holder.getBackgroundImage().reuse();
    }
}
