//package com.quliantrip.qulian.adapter;
//
//import java.util.ArrayList;
//
//import android.text.TextUtils;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//
//import com.nostra13.universalimageloader.core.ImageLoader;
//import com.teckjob.chaiplay.R;
//import com.teckjob.chaiplay.bean.CategoryInfo;
//import com.teckjob.chaiplay.golbal.ChaiplayApplication;
//import com.teckjob.chaiplay.golbal.ImageLoaderOptions;
//import com.teckjob.chaiplay.http.Url;
//
//public class CategoryAdapter extends BasicAdapter<Object> {
//
//	public CategoryAdapter(ArrayList<Object> list) {
//		super(list);
//	}
//
//	private final int TYPE_TITLE = 0;
//	private final int TYPE_INFO = 1;
//
//	// 获取类型的数量
//	@Override
//	public int getViewTypeCount() {
//		return 2;
//	}
//
//	// 返回当前的item属于哪个类型
//	@Override
//	public int getItemViewType(int position) {
//		Object object = list.get(position);
//		if (object instanceof String) {
//			return TYPE_TITLE;
//		} else {
//			return TYPE_INFO;
//		}
//	}
//
//	@Override
//	public View getView(int position, View convertView, ViewGroup parent) {
//		// 获取当前的item的属于的类型
//		int type = getItemViewType(position);
//		switch (type) {
//		case TYPE_TITLE:
//			if (convertView == null) {
//				convertView = View.inflate(ChaiplayApplication.getContext(),
//						R.layout.adapter_category_title, null);
//			}
//			TextView tv_title = (TextView) convertView
//					.findViewById(R.id.tv_title);
//			String text = (String) list.get(position);
//			tv_title.setText(text);
//			break;
//		case TYPE_INFO:
//			if (convertView == null) {
//				convertView = View.inflate(ChaiplayApplication.getContext(),
//						R.layout.adapter_category_info, null);
//			}
//			CategoryInfoHolder holder = CategoryInfoHolder
//					.getHolder(convertView);
//
//			CategoryInfo info = (CategoryInfo) list.get(position);
//
//			holder.tv_title1.setText(info.getName1());
//			ImageLoader.getInstance().displayImage(
//					Url.IMAGE_PREFIX + info.getUrl1(), holder.iv_icon1,
//					ImageLoaderOptions.options);
//
//			if (!TextUtils.isEmpty(info.getUrl2())) {
//				holder.ll_info2.setVisibility(View.VISIBLE);
//				holder.tv_title2.setText(info.getName2());
//				ImageLoader.getInstance().displayImage(
//						Url.IMAGE_PREFIX + info.getUrl2(), holder.iv_icon2,
//						ImageLoaderOptions.options);
//			} else {
//				holder.ll_info2.setVisibility(View.INVISIBLE);
//			}
//
//			if (!TextUtils.isEmpty(info.getUrl3())) {
//				holder.ll_info3.setVisibility(View.VISIBLE);
//
//				holder.tv_title3.setText(info.getName3());
//				ImageLoader.getInstance().displayImage(
//						Url.IMAGE_PREFIX + info.getUrl3(), holder.iv_icon3,
//						ImageLoaderOptions.options);
//			} else {
//				holder.ll_info3.setVisibility(View.INVISIBLE);
//			}
//			break;
//		}
//		return convertView;
//	}
//
//	static class CategoryInfoHolder {
//		ImageView iv_icon1, iv_icon2, iv_icon3;
//		TextView tv_title1, tv_title2, tv_title3;
//		LinearLayout ll_info2, ll_info3;
//
//		public CategoryInfoHolder(View convertView) {
//			iv_icon1 = (ImageView) convertView.findViewById(R.id.iv_icon1);
//			iv_icon2 = (ImageView) convertView.findViewById(R.id.iv_icon2);
//			iv_icon3 = (ImageView) convertView.findViewById(R.id.iv_icon3);
//			tv_title1 = (TextView) convertView.findViewById(R.id.tv_title1);
//			tv_title2 = (TextView) convertView.findViewById(R.id.tv_title2);
//			tv_title3 = (TextView) convertView.findViewById(R.id.tv_title3);
//			ll_info2 = (LinearLayout) convertView.findViewById(R.id.ll_info2);
//			ll_info3 = (LinearLayout) convertView.findViewById(R.id.ll_info3);
//		}
//
//		public static CategoryInfoHolder getHolder(View convertView) {
//			CategoryInfoHolder holder = (CategoryInfoHolder) convertView
//					.getTag();
//			if (holder == null) {
//				holder = new CategoryInfoHolder(convertView);
//				convertView.setTag(holder);
//			}
//			return holder;
//		}
//	}
//
//}
