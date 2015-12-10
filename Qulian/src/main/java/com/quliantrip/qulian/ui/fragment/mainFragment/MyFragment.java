package com.quliantrip.qulian.ui.fragment.mainFragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.quliantrip.qulian.R;
import com.quliantrip.qulian.base.BaseFragment;
import com.quliantrip.qulian.global.QulianApplication;
import com.quliantrip.qulian.ui.activity.MapActivity;
import com.quliantrip.qulian.util.CommonHelp;
import com.quliantrip.qulian.util.ToastUtil;
import com.quliantrip.qulian.util.UIHelper;
import com.quliantrip.qulian.view.RollViewPage;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yuly on 2015/11/9.
 */

public class MyFragment extends BaseFragment {
    @Bind(R.id.tv_me_setting)
    Button setting;
    @Bind(R.id.tv_me_username)
    TextView userName;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_main_me, null);
        ButterKnife.bind(this, view);
        userName.setText(QulianApplication.getInstance().getUser().getName());

        return view;
    }

    @Override
    public void initDate() {

    }

    @OnClick(R.id.tv_me_setting)
    void setting() {
        if (QulianApplication.getInstance().isLogin()) {
            ToastUtil.showToast(mContext, "已经登录请操作");
        } else {
            UIHelper.showMyActive(mContext);
        }

    }

    @OnClick(R.id.bt_map)
    void enterMap() {
        Intent intent = new Intent(mContext,MapActivity.class);
        startActivity(intent);

    }
}
