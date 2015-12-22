package com.quliantrip.qulian.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.quliantrip.qulian.R;
import com.quliantrip.qulian.domain.CityListBean;
import com.quliantrip.qulian.global.QulianApplication;
import com.quliantrip.qulian.ui.activity.SimpleBackActivity;
import com.quliantrip.qulian.ui.activity.mainAcivity.MainActivity;
import com.quliantrip.qulian.view.MyGridView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 城市分类的适配器对象
 * Created by Yuly on 2015/12/21.
 * www.quliantrip.com
 */
public class CountryCityListAdapter extends BasicAdapter<CityListBean.AreaArrEntity> {
    private Context mContext;

    public CountryCityListAdapter(ArrayList<CityListBean.AreaArrEntity> list) {
        super(list);
    }
    public void setmContext(Context context){
        this.mContext = context;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(QulianApplication.getContext(), R.layout.adapter_city_country, null);
        }
        Holder holder = Holder.getHolder(convertView);
        CityListBean.AreaArrEntity bean = list.get(position);
        holder.countryName.setText(bean.getName());
        holder.gridView.setAdapter(new ClassifyCityListAdapter((ArrayList<CityListBean.AreaArrEntity.ListEntity>)bean.getList()));
        holder.gridView.setFocusable(false);
        holder.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CityListBean.AreaArrEntity.ListEntity bean = ((CityListBean.AreaArrEntity.ListEntity) parent.getAdapter().getItem(position));
                Intent intent = new Intent(mContext, MainActivity.class);
                intent.putExtra("cityId",bean.getId());
                ((SimpleBackActivity) mContext).setResult(((SimpleBackActivity) mContext).RESULT_OK, intent);
                ((SimpleBackActivity) mContext).finish();
            }
        });
        return convertView;
    }

    static class Holder {
        @Bind(R.id.tv_city_country)
        TextView countryName;
        @Bind(R.id.mgv_city_list_country)
        MyGridView gridView;

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
