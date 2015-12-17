package com.quliantrip.qulian.ui.fragment.mainFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.quliantrip.qulian.R;
import com.quliantrip.qulian.base.BaseFragment;
import com.quliantrip.qulian.global.QulianApplication;
import com.quliantrip.qulian.util.UIHelper;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yuly on 2015/11/9.
 */

public class MyFragment extends BaseFragment {
    @Bind(R.id.rg_order_state)
    RadioGroup orderRadioGroup;
    //    @Bind(R.id.tv_me_setting)
//    Button setting;
//    @Bind(R.id.tv_me_username)
//    TextView userName;
//    @Bind(R.id.wv_map)
//    WebView map;
    private Bundle bundle = new Bundle();

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_main_me, null);
        ButterKnife.bind(this, view);
//        userName.setText(QulianApplication.getInstance().getUser().getName());
        initMap();
//        initOrderList();
        return view;
    }

    @OnClick(R.id.rb_order_all)
    void orderAll() {
        bundle.putInt("orderState", 0);
        UIHelper.showOrderList(mContext, bundle);
    }

    @OnClick(R.id.rb_order_nor)
    void ordernor() {
        bundle.putInt("orderState", 1);
        UIHelper.showOrderList(mContext, bundle);
    }

    @OnClick(R.id.rb_order_norUser)
    void ordernorUser() {
        bundle.putInt("orderState", 2);
        UIHelper.showOrderList(mContext, bundle);
    }

    @OnClick(R.id.rb_order_norAssess)
    void orderNorAssess() {
        bundle.putInt("orderState", 3);
        UIHelper.showOrderList(mContext, bundle);
    }

    @Override
    public void initDate() {

    }

    @OnClick(R.id.tv_me_setting)
    void setting() {
        if (QulianApplication.getInstance().isLogin()) {
            UIHelper.showMeSetting(mContext);
        } else {
            UIHelper.showMyActive(mContext);
        }

    }

//    @OnClick(R.id.bt_map)
//    void enterMap() {
//        Intent intent = new Intent(mContext,MapActivity.class);
//        startActivity(intent);
//
//    }

    private void initMap() {

//        WebSettings settings = map.getSettings();
//        map.loadUrl("http://www.quliantrip.com/index.php?ctl=deal&act=188");
//        settings.setJavaScriptEnabled(true);
//        map.loadUrl("http://www.quliantrip.com/wap/index.php?ctl=deal&act=map&id=192");
//        WebSettings ws = map.getSettings();
//        ws.setAllowFileAccess(true);
//        ws.setJavaScriptEnabled(true);
//        map.setWebViewClient(new WebViewClient() {
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                //  重写此方法表明点击网页里面的链接还是在当前的webview里跳转，不跳到浏览器那边
//
//                return true;
//            }
//        });


//        这里使用的是加载完成后的回调监听
//        map.setWebViewClient(new WebViewClient() {
//            //    ؽ     ɵ
//            @Override
//            public void onPageFinished(WebView view, String url) {
////                loading.setVisibility(View.GONE);
//                map.setVisibility(View.VISIBLE);
//                super.onPageFinished(view, url);
//            }
//
//            @Override
//            public void onPageStarted(WebView view, String url, Bitmap favicon) {
//
//                super.onPageStarted(view, url, favicon);
//            }
//        });
    }
}
