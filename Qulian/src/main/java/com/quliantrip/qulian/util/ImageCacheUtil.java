package com.quliantrip.qulian.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.LruCache;

/**
 * 进行图片缓存的类
 * */
public class ImageCacheUtil {
	public static final int SUCCESS = 100;
	public static final int FAILER = 101;

	private File cacheDir;
	private ExecutorService threadPool;
	private Handler handler;
	private LruCache<String, Bitmap> lruCache;

	public ImageCacheUtil(Context context, Handler handler) {
		super();
		int maxSize = (int) (Runtime.getRuntime().maxMemory() / 8);
		lruCache = new LruCache<String, Bitmap>(maxSize) {
			@Override
			protected int sizeOf(String key, Bitmap value) {
				return value.getRowBytes() * value.getHeight();
			}
		};
		cacheDir = context.getCacheDir();
		threadPool = Executors.newFixedThreadPool(5);
		this.handler = handler;
	}

	public Bitmap getBitMap(String url, int position) {
		Bitmap bitmap = null;
		bitmap = lruCache.get(url);
		if (bitmap != null) {
			return bitmap;
		}
		bitmap = getLocalCache(url);
		if (bitmap != null) {
			return bitmap;
		}
		getBitMapFromNet(url, position);
		return null;
	}

	private void getBitMapFromNet(String url, int position) {
		threadPool.execute(new MyRunnable(url, position)); 
		new AsyncTask<Void, Void, Void>(){

			@Override
			protected Void doInBackground(Void... params) {
				return null;
			}};
	}

	private class MyRunnable implements Runnable {
		private String imageUrl;
		private int position;

		public MyRunnable(String imageUrl, int position) {
			super();
			this.imageUrl = imageUrl;
			this.position = position;
		}


		public void run() {
			Message message = handler.obtainMessage();
			try {
				URL url = new URL(imageUrl);
				HttpURLConnection conn = (HttpURLConnection) url
						.openConnection();
				conn.setRequestMethod("GET");
				conn.setReadTimeout(3000);
				conn.setConnectTimeout(3000);
				InputStream inputStream = conn.getInputStream();
				Bitmap bitMap = BitmapFactory.decodeStream(inputStream);
				setLocalcache(imageUrl, bitMap);
				lruCache.put(imageUrl, bitMap);
				message.what = SUCCESS;
				message.obj = bitMap;
				message.arg1 = position;
				handler.sendMessage(message);

				return;
			} catch (IOException e) {
				e.printStackTrace();
			}
			message.what = FAILER;
			handler.sendMessage(message);
		}
	}

	private Bitmap getLocalCache(String url) {
		try {
			String fileName = MD5Encoder.encode(url).substring(10);
			File file = new File(cacheDir, fileName);
			Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
			lruCache.put(url, bitmap);
			return bitmap;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setLocalcache(String url, Bitmap bitmap) {
		try {
			String fileName = MD5Encoder.encode(url).substring(10);
			File file = new File(cacheDir, fileName);
			FileOutputStream out = new FileOutputStream(file);
			bitmap.compress(CompressFormat.JPEG, 100, out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
