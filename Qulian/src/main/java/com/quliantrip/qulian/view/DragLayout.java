//package com.quliantrip.qulian.view;
//
//import com.nineoldandroids.view.ViewHelper;
//
//import android.content.Context;
//import android.graphics.Color;
//import android.graphics.PorterDuff.Mode;
//import android.support.v4.view.ViewCompat;
//import android.support.v4.widget.ViewDragHelper;
//import android.support.v4.widget.ViewDragHelper.Callback;
//import android.util.AttributeSet;
//import android.view.MotionEvent;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.FrameLayout;
//
//public class DragLayout extends FrameLayout {
//
//	private ViewDragHelper viewDragHelper;
//	// 建立回调类,用于提供信息和接收时间
//	private Callback callback = new Callback() {
//
//		// 该方法是触摸子view时进行调用，是否捕获，child表示触摸的子view，pointerId表示多触摸点
//		@Override
//		public boolean tryCaptureView(View child, int pointerId) {
//			return child == mLeftContent || child == mMainContent;
//		}
//
//		// 修正view水平方向上的值，
//		@Override
//		public int clampViewPositionHorizontal(View child, int left, int dx) {
//			// 进行边界的判断
//			if (child == mMainContent)
//				left = fixLeft(left);
//			return left;
//		};
//
//		private int fixLeft(int left) {
//			if (left < 0) {
//				left = 0;
//			} else if (left > mDragRange) {
//				left = mDragRange;
//			}
//			return left;
//		};
//
//		// 这个方法不重要, 但是必须有, 不影响水平方向的拖拽范围
//		// 影响松手之后的动画执行时间, 如果页面中有ListView等可以滑动的控件时, 这个方法必须返回大于0的值
//		// 否则就无法拖动了
//		public int getViewHorizontalDragRange(View child) {
//			return mDragRange;
//		};
//
//		public void onViewPositionChanged(View changedView, int left, int top,
//				int dx, int dy) {
//			if (changedView == mLeftContent) {
//				mLeftContent.layout(0, 0, mWidth, mHeight);
//				int newLeft = mMainContent.getLeft() + dx;
//				newLeft = fixLeft(newLeft);
//				mMainContent.layout(newLeft, 0, newLeft + mWidth, mHeight);
//			}
//			dispatchDragState(mMainContent.getLeft());
//			invalidate();
//		}
//
//		//vel表示的是x或y方向上的速度的
//		public void onViewReleased(View releasedChild, float xvel, float yvel) {
//			if (xvel == 0.0f && mMainContent.getLeft() < mDragRange * 0.5f) {
//				close();
//			} else if (xvel < 0) {
//				close();
//			} else {
//				open();
//			}
//		};
//	};
//<img src="http://www.quliantrip.com/public/attachment/201511/20/16/564ed3762c8e5.png" border="0" style="width:100%;"></a>
//
//
// 	public enum State {
//		CLOSE, OPEN, DRAGGING
//	}
//    private State mState = State.CLOSE;
//    private OnDragStateChangeListener mOnDragStateChangeListener;
//
//    public interface OnDragStateChangeListener {
//        void onClose();
//        void onOpen();
//        void onDragging(float percent);
//    }
//
//    public State getState() {
//        return mState;
//    }
//
//    public void setState(State state) {
//        mState = state;
//    }
//
//    public OnDragStateChangeListener getOnDragStateChangeListener() {
//        return mOnDragStateChangeListener;
//    }
//
//    public void setOnDragStateChangeListener(OnDragStateChangeListener onDragStateChangeListener) {
//        mOnDragStateChangeListener = onDragStateChangeListener;
//    }
//
//	protected void dispatchDragState(int left) {
//		float percent = left * 1.0f / mDragRange;
//		State preState = mState;
//		mState = updateState(percent);
//		if (mOnDragStateChangeListener != null) {
//			mOnDragStateChangeListener.onDragging(percent);
//			if (preState != mState) {
//				if (mState == State.CLOSE) {
//					mOnDragStateChangeListener.onClose();
//				} else if (mState == State.OPEN) {
//					mOnDragStateChangeListener.onOpen();
//				}
//			}
//		}
//		animViews(percent);
//	}
//
//	private State updateState(float percent) {
//		if (percent == 0.0f) {
//			return State.CLOSE;
//		} else if (percent == 1.0f) {
//			return State.OPEN;
//		} else {
//			return State.DRAGGING;
//		}
//	}
//
//	private void animViews(float percent) {
//		ViewHelper.setScaleX(mMainContent, 1.0f + (0.8f - 1.0f) * percent);
//		ViewHelper.setScaleY(mMainContent, 1.0f + (0.8f - 1.0f) * percent);
//		ViewHelper.setScaleX(mLeftContent, 0.5f + (1.0f - 0.5f) * percent);
//		ViewHelper.setScaleY(mLeftContent, 0.5f + (1.0f - 0.5f) * percent);
//
//
//		ViewHelper.setTranslationX(mLeftContent,
//				EvaluateUtil.evaluateFloat(percent, -mWidth * 0.5f, 0));
//		ViewHelper.setAlpha(mLeftContent,
//				EvaluateUtil.evaluateFloat(percent, 0.0f, 1.0f));
//		getBackground().setColorFilter(
//				(Integer) EvaluateUtil.evaluateArgb(percent, Color.BLACK,
//						Color.TRANSPARENT), Mode.SRC_OVER);
//	}
//
//	protected void open() {
//		open(true);
//	}
//
//	public void open(boolean isSmooth) {
//		int finalLeft = mDragRange;
//		if (isSmooth) {
//			viewDragHelper.smoothSlideViewTo(mMainContent, finalLeft, 0);
//			invalidate();
//		} else {
//			mMainContent.layout(finalLeft, 0, finalLeft + mWidth, mHeight);
//		}
//	}
//
//	protected void close() {
//		close(true);
//	}
//
//	public void close(boolean isSmooth) {
//		int finalLeft = 0;
//		if (isSmooth) {
//			viewDragHelper.smoothSlideViewTo(mMainContent, finalLeft, 0);
//			invalidate();
//		} else {
//			mMainContent.layout(finalLeft, 0, finalLeft + mWidth, mHeight);
//		}
//	}
//
//	private ViewGroup mLeftContent;
//	private ViewGroup mMainContent;
//	private int mWidth;
//	private int mHeight;
//	private int mDragRange;
//
//	public DragLayout(Context context) {
//		this(context, null);
//	}
//
//	public DragLayout(Context context, AttributeSet attrs) {
//		this(context, attrs, -1);
//	}
//
//	// 该构造函数外部不调用，可以让前面的两个进行调用。
//	public DragLayout(Context context, AttributeSet attrs, int defStyle) {
//		super(context, attrs, defStyle);
//		init();
//	}
//
//	private void init() {
//		// 第一参数表示
//		viewDragHelper = ViewDragHelper.create(this, callback);
//	}
//
//	// 让ViewDrawhelper进行决定时间的传递和touch
//	@Override
//	public boolean onInterceptTouchEvent(MotionEvent ev) {
//		return viewDragHelper.shouldInterceptTouchEvent(ev);
//	}
//
//	@Override
//	public boolean onTouchEvent(MotionEvent event) {
//		viewDragHelper.processTouchEvent(event);
//		return true;
//	}
//
//	// 在该自定义的viewgroup都加载完毕之后进行调用的方法，获取要进行viewDraw的控件。
//	@Override
//	protected void onFinishInflate() {
//		super.onFinishInflate();
//		// 严谨性的判断
//		if (getChildCount() < 2) {
//			throw new RuntimeException("You must have at least 2 child views");
//		}
//		// 进行类型的判断
//		if (!(getChildAt(0) instanceof ViewGroup)
//				|| !(getChildAt(1) instanceof ViewGroup)) {
//			throw new IllegalArgumentException(
//					"Your child views must be ViewGroup");
//		}
//		mLeftContent = (ViewGroup) getChildAt(0);
//		mMainContent = (ViewGroup) getChildAt(1);
//	}
//
//	@Override
//	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//	}
//
//	// 在View的宽高改变后调用, 一定是在onMeasure方法之后调用的
//	@Override
//	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
//		super.onSizeChanged(w, h, oldw, oldh);
//		mWidth = mMainContent.getMeasuredWidth();
//		mHeight = mMainContent.getMeasuredHeight();
//		mDragRange = (int) (mWidth * 0.6f);
//	}
//
//	@Override
//    public void computeScroll() {
//        super.computeScroll();
//        if (viewDragHelper.continueSettling(true)) {
//            ViewCompat.postInvalidateOnAnimation(this);
//        }
//    }
//
//}
