package com.quliantrip.qulian.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.quliantrip.qulian.R;
import com.quliantrip.qulian.domain.CityListBean;
import com.quliantrip.qulian.global.QulianApplication;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Yuly on 2015/12/21.
 * www.quliantrip.com
 */
public class HotCityListAdapter extends BasicAdapter<CityListBean.HotCityEntity> {


    public HotCityListAdapter(ArrayList<CityListBean.HotCityEntity> list) {
        super(list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(QulianApplication.getContext(), R.layout.adapter_city_item, null);
        }
        Holder holder = Holder.getHolder(convertView);
        CityListBean.HotCityEntity bean = list.get(position);
        holder.city.setText(bean.getName());
        return convertView;
    }

    static class Holder {
        @Bind(R.id.tv_city)
        TextView city;

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
