package com.example.tangxb.myapplication;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * Created by Tangxb on 2016/3/9.
 */
public class MyGlideUtils {
    private static int mContainerW = 1200;
    private static int mNeedItemH = 900;

    public static void setPreWork(int containerW, int needItemH) {
        MyGlideUtils.mContainerW = containerW;
        MyGlideUtils.mNeedItemH = needItemH;
    }

    public static void loadImgByUrlOverride(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .centerCrop()
                        // this is very import , because the ParallaxImageView need actually height should > it's measured height
                        // so we should provide this height to download
                .override(mContainerW, mNeedItemH)
                        // use disk cache
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.mipmap.ic_launcher)
                .into(imageView);
    }

    public static void loadImgByUrlCommon(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.mipmap.ic_launcher)
                .into(imageView);
    }
}
