package com.quliantrip.qulian.ui.activity;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;

import com.quliantrip.qulian.R;
import com.quliantrip.qulian.base.BaseSwipeBackActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Yuly on 2015/12/10.
 * www.quliantrip.com
 */
public class MapActivity extends BaseSwipeBackActivity {

    @Bind(R.id.wv_map)
    WebView map;
    @Bind(R.id.map_loading)
    FrameLayout loading;


    @Override
    public int getContentViewId() {
        return R.layout.activity_map;
    }

    @Override
    public void initFindView() {
        ButterKnife.bind(this);
        initMap();
    }

    @Override
    public void initData() {

    }

    private void initMap() {

//        WebSettings settings = map.getSettings();
//        map.loadUrl("http://www.quliantrip.com/index.php?ctl=deal&act=188");
//        settings.setJavaScriptEnabled(true);
        map.loadUrl("http://www.quliantrip.com/wap/index.php?ctl=deal&act=map&id=192");
        WebSettings ws = map.getSettings();
        ws.setAllowFileAccess(true);
        ws.setJavaScriptEnabled(true);
//        这里使用的是加载完成后的回调监听
        map.setWebViewClient(new WebViewClient() {
            //    ؽ     ɵ
            @Override
            public void onPageFinished(WebView view, String url) {
                loading.setVisibility(View.GONE);
                map.setVisibility(View.VISIBLE);
                super.onPageFinished(view, url);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {

                super.onPageStarted(view, url, favicon);
            }
        });
    }
//    @OnClick(R.id.iv_map_back) void mapBack(){
//        finish();
//    }
}
