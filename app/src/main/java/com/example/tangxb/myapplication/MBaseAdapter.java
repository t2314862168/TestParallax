package com.example.tangxb.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tangxb on 2016/3/9.
 */
public abstract class MBaseAdapter<T> extends RecyclerView.Adapter<MBaseViewHolder> {
    protected Context mBaseContext;
    protected ArrayList<T> mBaseList;

    public abstract MBaseViewHolder createViewHolder(View view);

    public abstract View createView(ViewGroup viewGroup);

    public abstract void showData(MBaseViewHolder holder, int position, List<T> list);

    public MBaseAdapter(Context context) {
        mBaseContext = context;
        mBaseList = new ArrayList<T>();
    }

    @Override
    public MBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = createView(parent);
        MBaseViewHolder holder = createViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MBaseViewHolder holder, int position) {
        showData(holder, position, mBaseList);
    }

    @Override
    public int getItemCount() {
        return mBaseList != null ? mBaseList.size() : 0;
    }

    public void addEntity(T entity) {
        mBaseList.add(entity);
        notifyDataSetChanged();
    }

    public void addEntity(List<T> tempList) {
        if (tempList != null && tempList.size() > 0) {
            mBaseList.addAll(tempList);
            notifyDataSetChanged();
        }
    }
}
