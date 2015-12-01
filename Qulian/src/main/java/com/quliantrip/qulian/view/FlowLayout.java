package com.quliantrip.qulian.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FlowLayout extends ViewGroup {
	private int SPACING_DEFAUT = 10;
	private int verticalSpacing = SPACING_DEFAUT;
	private int horizontalSpacing = SPACING_DEFAUT;
	private ArrayList<Line> lineList = new ArrayList<Line>();

	public void setVerticalSpacing(int verticalSpacing) {
		if (verticalSpacing > 0)
			this.verticalSpacing = verticalSpacing;
	}

	public void setHorizontalSpacing(int horizontalSpacing) {
		if (horizontalSpacing > 0)
			this.horizontalSpacing = horizontalSpacing;
	}

	public FlowLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public FlowLayout(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public FlowLayout(Context context) {
		this(context, null);
	}

	// 进行行的划分
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);//表示对本view进行设置
		// 获取宽
		int width = MeasureSpec.getSize(widthMeasureSpec);
		int noPaddingWidth = width - getPaddingLeft() - getPaddingRight();
		Line line = new Line();
		for (int i = 0; i < getChildCount(); i++) {
			View childView = getChildAt(i);
			childView.measure(0, 0);// 让系统进行测量数据
			if (line.getViewList().size() == 0) {
				line.addLineView(childView);
			} else if (line.getWidth() + horizontalSpacing
					+ childView.getMeasuredWidth() > noPaddingWidth) {
				lineList.add(line);
				line = new Line();
				line.addLineView(childView);
			} else {
				line.addLineView(childView);
			}
			// 应为在一个line的空白的区域不够一个子view添加时才进行把line添加到集合中去，所以在最后一个要进行把不满的line添加进去。
			if (getChildCount() - 1 == i) {
				lineList.add(line);
			}
		}

		// 获取高度
		int height = getPaddingBottom() + getPaddingTop();
		for (int i = 0; i < lineList.size(); i++) {
			height += lineList.get(i).getHeight();
		}
		height += (lineList.size() - 1) * verticalSpacing;
		
		setMeasuredDimension(width, height);//向父View申请对应的宽高
	}

	// 进行位置的放置
	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {

		int paddingTop = getPaddingTop();
		int paddingLeft = getPaddingLeft();
		// 进行行的、的放置
		for (int i = 0; i < lineList.size(); i++) {
			Line line = lineList.get(i);
			if (i > 0) {
				paddingTop += lineList.get(i - 1).getHeight() + verticalSpacing;
			}
			ArrayList<View> viewList = line.getViewList();
			//获取剩余的可用的控件
			int remainSpacing = getRemianSpaicing(line);
			float everyRemain = remainSpacing / viewList.size();
			// 进行每一列的放置，在进行摆放时候要进行一行一行的进行，后一列一列的放置。
			for (int j = 0; j < viewList.size(); j++) {
				View childView = viewList.get(j);
				// 添加每个控件多剩余的部分进行从新measure
				 int widthMeasureSpec = MeasureSpec.makeMeasureSpec((int)(childView.getMeasuredWidth()+everyRemain),MeasureSpec.EXACTLY);
				 childView.measure(widthMeasureSpec,0);//从新进行测量进行设置器宽和高
				// 进行layout的放置
				if (j == 0) {
					childView.layout(paddingLeft, paddingTop, paddingLeft
							+ childView.getMeasuredWidth(), paddingTop
							+ childView.getMeasuredHeight());
				} else {
					View preChildView = viewList.get(j - 1);
					int left = preChildView.getRight() + horizontalSpacing;
					childView.layout(left, preChildView.getTop(), left
							+ childView.getMeasuredWidth(),
							preChildView.getBottom());
				}
			}

		}

	}

	private int getRemianSpaicing(Line line) {
		return getMeasuredWidth() - getPaddingLeft() - getPaddingRight()
				- line.getWidth();
	}

	private class Line {
		private ArrayList<View> viewList = new ArrayList<View>();
		private int width;
		private int height;

		public void addLineView(View lineView) {
			if (!viewList.contains(lineView)) {
				viewList.add(lineView);
				if (viewList.size() == 1) {
					width = lineView.getMeasuredWidth();
				} else {
					width += horizontalSpacing + lineView.getMeasuredWidth();
				}
				height = Math.max(height, lineView.getMeasuredHeight());
			}
		}

		public ArrayList<View> getViewList() {
			return viewList;
		}

		public void setViewList(ArrayList<View> viewList) {
			this.viewList = viewList;
		}

		public int getWidth() {
			return width;
		}

		public void setWidth(int width) {
			this.width = width;
		}

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}

	}
}
