package com.quliantrip.qulian.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.ImageView;

import com.quliantrip.qulian.R;

public class RatioImageView extends ImageView {
	private float ratio = 1.5f;

	public RatioImageView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);

		TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.RatioImageView);

		ratio = a.getFloat(R.styleable.RatioImageView_ratioscale, 0f);
	}

	public RatioImageView(Context context, AttributeSet attrs) {
		this(context, attrs,0);
	}

	public RatioImageView(Context context) {
		super(context,null);
	}
	
	//第一种进行设置进行添加
	public void setRatio(float ratio) {
		this.ratio = ratio;
	}

	//是measure中的有对onmease()进行了回调进行了调用。
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		//通过测量的的静态方法来获取一些属性的值，进行显示
		int width = MeasureSpec.getSize(widthMeasureSpec);
		if(ratio != 0){
			//获取值进行重新设置值
			int height = (int) (width/ratio);
			heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);
		}
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}
}
