package com.quliantrip.qulian.global;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.quliantrip.qulian.R;

/**
 * 图片加载的定义的属性
 */
public interface ImageLoaderOptions {

    DisplayImageOptions options = new DisplayImageOptions.Builder()
            .showImageOnLoading(R.mipmap.bg_default_min)// 加载图片过程中显示哪张图片
            .showImageForEmptyUri(R.mipmap.bg_default_min)// url为空的话显示哪张图片
            .showImageOnFail(R.mipmap.bg_default_min)// 加载图片失败显示哪张图片
            .cacheInMemory(true)// 在内存中缓存该图片
            .cacheOnDisk(true)// 在硬盘中缓存该图片
            .considerExifParams(true)// 会识别图片的方向信息
            // .displayer(new FadeInBitmapDisplayer(800)).build();//渐渐显示的动画效果
            .displayer(new RoundedBitmapDisplayer(10)).build();// 圆角的效果

    DisplayImageOptions pager_options = new DisplayImageOptions.Builder()
            .showImageOnLoading(R.mipmap.bg_default_min)// 加载图片过程中显示哪张图片
            .showImageForEmptyUri(R.mipmap.bg_default_min)// url为空的话显示哪张图片
            .showImageOnFail(R.mipmap.bg_default_min)// 加载图片失败显示哪张图片
            .cacheInMemory(true)// 在内存中缓存该图片
            .cacheOnDisk(true)// 在硬盘中缓存该图片
            .considerExifParams(true)// 会识别图片的方向信息
            .displayer(new FadeInBitmapDisplayer(800)).build();//渐渐显示的动画效果
    DisplayImageOptions pager_options_big = new DisplayImageOptions.Builder()
            .showImageOnLoading(R.mipmap.bg_default_big)// 加载图片过程中显示哪张图片
            .showImageForEmptyUri(R.mipmap.bg_default_big)// url为空的话显示哪张图片
            .showImageOnFail(R.mipmap.bg_default_big)// 加载图片失败显示哪张图片
            .cacheInMemory(true)// 在内存中缓存该图片
            .cacheOnDisk(true)// 在硬盘中缓存该图片
            .considerExifParams(true)// 会识别图片的方向信息
            .displayer(new FadeInBitmapDisplayer(800)).build();//渐渐显示的动画效果

    DisplayImageOptions options_big = new DisplayImageOptions.Builder()
            .showImageOnLoading(R.mipmap.bg_default_big)// 加载图片过程中显示哪张图片
            .showImageForEmptyUri(R.mipmap.bg_default_big)// url为空的话显示哪张图片
            .showImageOnFail(R.mipmap.bg_default_big)// 加载图片失败显示哪张图片
            .cacheInMemory(true)// 在内存中缓存该图片
            .cacheOnDisk(true)// 在硬盘中缓存该图片
            .considerExifParams(true)// 会识别图片的方向信息
            // .displayer(new FadeInBitmapDisplayer(800)).build();//渐渐显示的动画效果
            .displayer(new RoundedBitmapDisplayer(10)).build();// 圆角的效果
}
