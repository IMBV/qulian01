package com.quliantrip.qulian.view.HorizontalScroll;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.quliantrip.qulian.R;
import com.quliantrip.qulian.global.ImageLoaderOptions;
import com.quliantrip.qulian.util.CommonHelp;

import java.util.List;

/**
 * Created by yuly on 2015/12/1.
 */
public class HorizontalScrollViewAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private List<String> mDatas;

    public HorizontalScrollViewAdapter(Context context, List<String> mDatas)
    {
        this.mContext = context;
        mInflater = LayoutInflater.from(context);
        this.mDatas = null;
        this.mDatas = mDatas;
    }

    public int getCount()
    {
        return mDatas.size();
    }

    public Object getItem(int position)
    {
        return mDatas.get(position);
    }

    public long getItemId(int position)
    {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder viewHolder = null;
        if (convertView == null)
        {
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(
                    R.layout.view_horizontalscrollview_item, parent, false);
            viewHolder.mImg = (ImageView) convertView
                    .findViewById(R.id.iv_home_horizontalscroll_pic);
//            viewHolder.mText = (TextView) convertView
//                    .findViewById(R.id.tv_home_horizontalscroll_title);

            convertView.setTag(viewHolder);
        } else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) viewHolder.mImg.getLayoutParams();

        if(position==0){

        }else{
            params.leftMargin = CommonHelp.dip2px(mContext,5);
        }
        viewHolder.mImg.setLayoutParams(params);
        ImageLoader.getInstance().displayImage(mDatas.get(position), viewHolder.mImg, ImageLoaderOptions.options);

//        viewHolder.mText.setText("some");

        return convertView;
    }

    private class ViewHolder
    {
        ImageView mImg;
//        TextView mText;
    }
}
