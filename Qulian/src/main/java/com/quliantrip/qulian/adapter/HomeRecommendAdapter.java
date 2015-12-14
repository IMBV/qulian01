package com.quliantrip.qulian.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.quliantrip.qulian.R;
import com.quliantrip.qulian.domain.HomeRecommendBean;
import com.quliantrip.qulian.global.ImageLoaderOptions;
import com.quliantrip.qulian.global.QulianApplication;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Yuly on 2015/12/10.
 * www.quliantrip.com
 */
public class HomeRecommendAdapter extends BasicAdapter<HomeRecommendBean> {

    public HomeRecommendAdapter(ArrayList<HomeRecommendBean> list) {
        super(list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = View.inflate(QulianApplication.getContext(),R.layout.adapter_home_recommend_play,null);
        }
        Holder holder = Holder.getHolder(convertView);
        holder.des.setText(list.get(position).getDes());
        ImageLoader.getInstance().displayImage(list.get(position).getImageUrl(), holder.pic, ImageLoaderOptions.pager_options);
        return convertView;
    }
    static class Holder{
        @Bind(R.id.iv_home_recommend_pic) ImageView pic ;
        @Bind(R.id.iv_home_recommend_des)TextView des;
        public Holder(View convertView) {
            super();
            ButterKnife.bind(this,convertView);
        }

        public static Holder getHolder(View convertView){
            Holder holder = (Holder) convertView.getTag();
            if(holder == null){
                holder = new Holder(convertView);
                convertView.setTag(holder);
            }
            return holder;
        }

    }
}
