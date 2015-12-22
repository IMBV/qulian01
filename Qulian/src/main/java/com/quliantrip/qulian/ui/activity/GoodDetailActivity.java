package com.quliantrip.qulian.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;

import com.quliantrip.qulian.R;
import com.quliantrip.qulian.ui.activity.mainAcivity.MainActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

/**
 * Created by Yuly on 2015/12/18.
 * www.quliantrip.com
 */
public class GoodDetailActivity extends SwipeBackActivity {
    private Context mContext;
    @Bind(R.id.wv_good_detail)
    WebView mGoodDetail;
    @Bind(R.id.pb_good_list_loading)
    FrameLayout loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_good_detail);
        ButterKnife.bind(this);
        mContext = this;
        initDate();
    }

    //添加数据
    private void initDate() {
        mGoodDetail.addJavascriptInterface(new QulianInterface(), "qulianInterface");

        mGoodDetail.loadUrl(getIntent().getStringExtra("goodId"));
//        mGoodDetail.loadUrl("http://192.168.0.187/index04.html");
//        mGoodDetail.loadUrl("http://192.168.0.193:8080/test.html");
        mGoodDetail.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);

        mGoodDetail.getSettings().setJavaScriptEnabled(true);
        mGoodDetail.getSettings().setAllowFileAccess(true);
//        mGoodDetail.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        mGoodDetail.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {

                loading.setVisibility(View.GONE);
                mGoodDetail.setVisibility(View.VISIBLE);
                super.onPageFinished(view, url);
                String content = "android";
                mGoodDetail.loadUrl("javascript:javacalljswithargs('" + content + "')");
//                String content = "android";
//                mGoodDetail.loadUrl("javascript:androidcalljs('android')");
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }
        });
    }

//    /**
//     * Js调用的JavascriptInterface
//     */
//    public class QulianInterface {
//        /**
//         * 因为安全问题，在Android4.2以后(如果应用的android:targetSdkVersion数值为17+)
//         * JS只能访问带有 @JavascriptInterface注解的Java函数。
//         */
//        @JavascriptInterface
//        public void closeWebview() {
//
//        }
//
//        @JavascriptInterface
//        public void loginView(String content) {
//
//        }
//    }

//    @OnClick(R.id.asdfasdfa) void cdlskafj(){
//        String content = "android22124545464";
//        mGoodDetail.loadUrl("javascript:javacalljswithargs('" + content + "')");
//    }

    /**
     * Js调用的JavascriptInterface
     */
    public class QulianInterface {
        @JavascriptInterface
        public void startFunction() {
            Intent intent = new Intent(mContext, MainActivity.class);
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
