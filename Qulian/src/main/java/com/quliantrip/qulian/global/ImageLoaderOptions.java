package com.quliantrip.qulian.global;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.quliantrip.qulian.R;

public interface ImageLoaderOptions {
	DisplayImageOptions options = new DisplayImageOptions.Builder()
			.showImageOnLoading(R.mipmap.ic_erweima_nor)// 加载图片过程中显示哪张图片
			.showImageForEmptyUri(R.mipmap.ic_erweima_nor)// url为空的话显示哪张图片
			.showImageOnFail(R.mipmap.ic_erweima_nor)// 加载图片失败显示哪张图片
			.cacheInMemory(true)// 在内存中缓存该图片
			.cacheOnDisk(true)// 在硬盘中缓存该图片
			.considerExifParams(true)// 会识别图片的方向信息
			// .displayer(new FadeInBitmapDisplayer(800)).build();//渐渐显示的动画效果
			.displayer(new RoundedBitmapDisplayer(28)).build();// 圆角的效果
	DisplayImageOptions pager_options = new DisplayImageOptions.Builder()
			.showImageOnLoading(R.mipmap.ic_erweima_nor)// 加载图片过程中显示哪张图片
			.showImageForEmptyUri(R.mipmap.ic_erweima_nor)// url为空的话显示哪张图片
			.showImageOnFail(R.mipmap.ic_erweima_nor)// 加载图片失败显示哪张图片
			.cacheInMemory(true)// 在内存中缓存该图片
			.cacheOnDisk(true)// 在硬盘中缓存该图片
			.considerExifParams(true)// 会识别图片的方向信息
			 .displayer(new FadeInBitmapDisplayer(800)).build();//渐渐显示的动画效果
//			.displayer(new RoundedBitmapDisplayer(28)).build();// 圆角的效果
}
