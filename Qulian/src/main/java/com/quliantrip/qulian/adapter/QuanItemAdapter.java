package com.quliantrip.qulian.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.quliantrip.qulian.R;
import com.quliantrip.qulian.domain.HomeBean;
import com.quliantrip.qulian.domain.TuanBean;
import com.quliantrip.qulian.global.ImageLoaderOptions;
import com.quliantrip.qulian.global.QulianApplication;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Yuly on 2015/12/10.
 * www.quliantrip.com
 */
public class QuanItemAdapter extends BasicAdapter<TuanBean.ItemEntity> {

    public QuanItemAdapter(ArrayList<TuanBean.ItemEntity> list) {
        super(list);
    }
    public void addList(ArrayList<TuanBean.ItemEntity> more){
        list.addAll(more);
        notifyDataSetChanged();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(QulianApplication.getContext(), R.layout.adapter_tuan_item, null);
        }
        Holder holder = Holder.getHolder(convertView);
        TuanBean.ItemEntity bean = list.get(position);
        ImageLoader.getInstance().displayImage(bean.getIcon(), holder.icon, ImageLoaderOptions.options);
        holder.name.setText(bean.getName());
        holder.subName.setText(bean.getSub_name());

        holder.newPrice.setText("￥"+bean.getCurrent_price());
        holder.oldPrice.setText("￥"+bean.getOrigin_price());
        holder.number.setText("已售："+bean.getBuy_count());
        return convertView;
    }

    static class Holder {
        @Bind(R.id.iv_tuan_quality_icon)
        ImageView icon;
        @Bind(R.id.iv_tuan_quality_name)
        TextView name;
        @Bind(R.id.iv_tuan_quality_subNname)
        TextView subName;

        @Bind(R.id.tv_tuan_deal_currentprice)
        TextView newPrice;
        @Bind(R.id.tv_tuan_deal_oldprice)
        TextView oldPrice;
        @Bind(R.id.tv_tuan_sale_number)
        TextView number;

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
