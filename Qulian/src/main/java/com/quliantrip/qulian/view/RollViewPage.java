package com.quliantrip.qulian.view;

import java.util.List;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.quliantrip.qulian.R;
import com.quliantrip.qulian.global.ImageLoaderOptions;


public class RollViewPage extends ViewPager {
	// viewpage要一起改变的数据
	private List<String> imageList;
	private List<View> dotList;

	private MyRunnable myRunnable;
	private int currentItem = 0;
	private MyPageAdapter myPageAdapter;

	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			currentItem = (currentItem + 1) % imageList.size();
			RollViewPage.this.setCurrentItem(currentItem);
			roll();
		};
	};
	private int downX;
	private int downY;

	public RollViewPage(Context context, List<String> iList, List<View> dList) {

		super(context);
		this.imageList = iList;
		this.dotList = dList;

		setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {

				for (int i = 0; i < dotList.size(); i++) {
					View view = dotList.get(i);
					if (position == i) {
						view.setBackgroundResource(R.drawable.shape_point_red);
					} else {
						view.setBackgroundResource(R.drawable.shape_point_gray);
					}
				}
			}

			@Override
			public void onPageScrolled(int position, float positionOffset,
					int positionOffsetPixels) {

			}

			@Override
			public void onPageScrollStateChanged(int state) {

			}
		});
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
//		// 在这里要进行添加的判断，来进行动作是否向下传递
//		switch (ev.getAction()) {
//		case MotionEvent.ACTION_DOWN:
//			getParent().requestDisallowInterceptTouchEvent(true);
//			downX = (int) ev.getX();
//			downY = (int) ev.getY();
//			break;
//
//		case MotionEvent.ACTION_MOVE:
//			int moveX = (int) ev.getX();
//			int moveY = (int) ev.getY();
//
//			if (Math.abs(moveX - downX) > Math.abs(moveY - downY)) {
//
//				if ((moveX - downX) < 0
//						&& getCurrentItem() == getAdapter().getCount() - 1) {
//					getParent().requestDisallowInterceptTouchEvent(false);
//				} else if ((moveX - downX) > 0 && getCurrentItem() == 0) {
//					getParent().requestDisallowInterceptTouchEvent(false);
//				} else {
//					getParent().requestDisallowInterceptTouchEvent(true);
//				}
//			} else {
//				getParent().requestDisallowInterceptTouchEvent(false);
//			}
//			break;
//		}
		return super.dispatchTouchEvent(ev);
	}

	public void roll() {
		if (myPageAdapter == null) {
			myPageAdapter = new MyPageAdapter();
			setAdapter(myPageAdapter);
		} else {
			myPageAdapter.notifyDataSetChanged();
		}
		handler.postDelayed(myRunnable, 5000);
	}

	private class MyRunnable implements Runnable {

		@Override
		public void run() {
			handler.obtainMessage().sendToTarget();
		}

	}

	class MyPageAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			return imageList.size();
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			return view == object;
		}

		@Override
		public Object instantiateItem(ViewGroup container, final int position) {
			View view = View.inflate(getContext(), R.layout.viewpager_item,
					null);
			ImageView image = (ImageView) view.findViewById(R.id.image);
			ImageLoader.getInstance().displayImage(imageList.get(position), image, ImageLoaderOptions.pager_options);
			// 点击图片的和进行回调函数的使用
			image.setOnTouchListener(new OnTouchListener() {

				private int downX;
				private int downY;
				private int startTime;

				@Override
				public boolean onTouch(View v, MotionEvent event) {
					switch (event.getAction()) {
					case MotionEvent.ACTION_DOWN:
						downX = (int) event.getX();
						downY = (int) event.getY();
						startTime = (int) System.currentTimeMillis();
						handler.removeCallbacksAndMessages(null);
						break;

					case MotionEvent.ACTION_UP:
						roll();
						int upX = (int) event.getX();
						int upY = (int) event.getY();
						int endTime = (int) System.currentTimeMillis();
						if ((endTime - startTime) < 500 && downX == upX
								&& downY == upY) {
							if (onTouchImage != null) {
								onTouchImage.touchImage(imageList.get(position));
							}
						}
						break;

					// 事件变为cancel事件，
					// 的原因是因为在dispach是父控件会进行操作所截取，该该活动的event会变成cancel的事件。
					case MotionEvent.ACTION_CANCEL:
						roll();
						break;
					}
					return true;
				}
			});

			container.addView(view);
			return view;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
		}

	}

	// 定义一个接口实现当点击图片是进行调用
	public interface OnTouchImage {
		public void touchImage(String url);
	}

	private OnTouchImage onTouchImage;

	public void setOnTouchImage(OnTouchImage onTouchImage) {
		this.onTouchImage = onTouchImage;
	}

	@Override
	protected void onDetachedFromWindow() {
		handler.removeCallbacksAndMessages(null);
		super.onDetachedFromWindow();
	}

}
