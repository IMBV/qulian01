package com.quliantrip.qulian.view.HorizontalScroll;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.quliantrip.qulian.R;
import com.quliantrip.qulian.domain.HomeBean;
import com.quliantrip.qulian.global.ImageLoaderOptions;
import com.quliantrip.qulian.util.CommonHelp;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by yuly on 2015/12/1.
 */
public class HorizontalScrollViewAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private List<HomeBean.IndexsEntity> mDatas;

    public HorizontalScrollViewAdapter(Context context, List<HomeBean.IndexsEntity> mDatas) {
        this.mContext = context;
        mInflater = LayoutInflater.from(context);
        this.mDatas = null;
        this.mDatas = mDatas;
    }

    public int getCount() {
        return mDatas.size();
    }

    public Object getItem(int position) {
        return mDatas.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.view_horizontalscrollview_item, parent, false);
        }
        Holder holder = Holder.getHolder(convertView);

        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) holder.pic.getLayoutParams();

        if (position == 0) {

        } else {
            params.leftMargin = CommonHelp.dip2px(mContext, 5);
        }

        holder.pic.setLayoutParams(params);
        HomeBean.IndexsEntity bean = mDatas.get(position);
        ImageLoader.getInstance().displayImage(bean.getImg(), holder.pic, ImageLoaderOptions.options);
        holder.name.setText(bean.getName());
        return convertView;
    }

    static class Holder {
        @Bind(R.id.iv_home_horizontalscroll_pic)
        ImageView pic;
        @Bind(R.id.tv_home_function_name)
        TextView name;

        public Holder(View convertView) {
            super();
            ButterKnife.bind(this, convertView);
        }

        public static Holder getHolder(View convertView) {
            Holder holder = (Holder) convertView.getTag();

            if (holder == null) {
                holder = new Holder(convertView);
                convertView.setTag(holder);
            }
            return holder;
        }

    }

}
