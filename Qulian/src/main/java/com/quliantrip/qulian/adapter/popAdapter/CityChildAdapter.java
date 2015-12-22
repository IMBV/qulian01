package com.quliantrip.qulian.adapter.popAdapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.quliantrip.qulian.R;
import com.quliantrip.qulian.domain.TuanBean;

import java.util.List;


public class CityChildAdapter extends BaseAdapter {

	Context mContext;
	List<TuanBean.QuanListEntity.QuanSubEntity> mChildArr;// 子item标题数组

	/**
	 * 构造方法
	 * 
	 * @param context
	 */
	public CityChildAdapter(Context context) {
		mContext = context;
	}

	/**
	 * 为子ListVitem设置要显示的数据
	 * 
	 * @param childArr
	 */
	public void setChildData(List<TuanBean.QuanListEntity.QuanSubEntity> childArr) {
		this.mChildArr = childArr;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = LayoutInflater.from(mContext).inflate(
					R.layout.item_child_layout, null);
			holder.childText = (TextView) convertView
					.findViewById(R.id.child_textView);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.childText.setText(mChildArr.get(position).getName());
		return convertView;
	}

	static class ViewHolder {
		TextView childText;
	}

	/**
	 * 获取item总数
	 */
	@Override
	public int getCount() {
		if (mChildArr == null) {
			return 0;
		}
		return mChildArr.size();
	}

	/**
	 * 获取某一个Item的内容
	 */
	@Override
	public Object getItem(int position) {
		return mChildArr.get(position);
	}

	/**
	 * 获取当前item的ID
	 */
	@Override
	public long getItemId(int position) {
		return position;
	}

}
