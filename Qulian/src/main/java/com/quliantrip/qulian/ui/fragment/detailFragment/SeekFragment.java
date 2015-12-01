package com.quliantrip.qulian.ui.fragment.detailFragment;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.quliantrip.qulian.R;
import com.quliantrip.qulian.util.ColorUtil;
import com.quliantrip.qulian.util.CommonHelp;
import com.quliantrip.qulian.util.DrawableUtil;
import com.quliantrip.qulian.util.ToastUtil;
import com.quliantrip.qulian.view.FlowLayout;

import java.util.ArrayList;

/**
 * Created by Qulian5 on 2015/11/30.
 */
public class SeekFragment extends Fragment {

    private FlowLayout flowLayout;
    private int textHPadding, textVPadding;
    private float hot_radius;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ScrollView scrollView = new ScrollView(getActivity());
        flowLayout = new FlowLayout(getActivity());

        textHPadding = (int) CommonHelp.getDimens(R.dimen.hot_text_hpading);
        textVPadding = (int) CommonHelp.getDimens(R.dimen.hot_text_vpading);
        hot_radius = CommonHelp.getDimens(R.dimen.hot_radius);

        // 1.设置四周的padding值
        int padding = (int) CommonHelp.getDimens(R.dimen.flowlayout_padding);
        flowLayout.setPadding(padding, padding, padding, padding);
        // 2.设置flowLayout的水平和垂直间距
        int spacing = (int) CommonHelp.getDimens(R.dimen.flowlayout_spacing);
        flowLayout.setHorizontalSpacing(spacing);
        flowLayout.setVerticalSpacing(spacing);
        scrollView.addView(flowLayout);
        return scrollView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ArrayList<String> list  = new ArrayList<String>();
        for(int j=0;j<120;j++){
            list.add("测试"+j);
        }
        for (int i = 0; i < list.size(); i++) {
            final TextView textView = new TextView(getActivity());
            textView.setText(list.get(i));
            textView.setTextColor(Color.WHITE);
            textView.setGravity(Gravity.CENTER);
            textView.setTextSize(16);
            textView.setPadding(textHPadding, textVPadding,
                    textHPadding, textVPadding);

            Drawable normal = DrawableUtil.generateDrawable(
                    ColorUtil.randomColor(), hot_radius);
            Drawable pressed = DrawableUtil.generateDrawable(
                    ColorUtil.randomColor(), hot_radius);
            textView.setBackgroundDrawable(DrawableUtil
                    .generateSelector(pressed, normal));

            flowLayout.addView(textView);

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToastUtil.showToast(getActivity(), textView.getText()
                            .toString());
                }
            });
        }
    }
}
