package com.quliantrip.qulian.ui.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;

import com.quliantrip.qulian.R;
import com.quliantrip.qulian.net.constant.HttpConstants;
import com.quliantrip.qulian.ui.activity.mainAcivity.MainActivity;
import com.quliantrip.qulian.util.ToastUtil;

import butterknife.Bind;
import butterknife.ButterKnife;
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

    //加载布局进行显示数据
    private void initDate() {
        mGoodDetail.addJavascriptInterface(new QulianInterface(), "qulianInterface");

        mGoodDetail.loadUrl(getIntent().getStringExtra("goodId"));

//        mGoodDetail.loadUrl("http://dev.qulian.com/wap/index.php?ctl=uc_ecv&act=exchange");

        mGoodDetail.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);

        mGoodDetail.getSettings().setJavaScriptEnabled(true);
        mGoodDetail.getSettings().setAllowFileAccess(true);
        mGoodDetail.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);

        mGoodDetail.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                if ("finish".equals(getIntent().getStringExtra("isFinish"))) {
                    mGoodDetail.loadUrl("javascript:androidloginout()");
                    finish();
                }
                if (getIntent().getStringExtra("goodId").toString().endsWith("ctl=user&act=login")) {
                    String content = "android";
                    mGoodDetail.loadUrl("javascript:javacalljswithargs('" + content + "')");
                }

                loading.setVisibility(View.GONE);
                mGoodDetail.setVisibility(View.VISIBLE);
                super.onPageFinished(view, url);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }
        });

        mGoodDetail.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
                AlertDialog.Builder b2 = new AlertDialog.Builder(GoodDetailActivity.this)
                        .setTitle("提示信息").setMessage(message)
                        .setPositiveButton("确定", new AlertDialog.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                result.confirm();
                            }
                        });
                b2.setCancelable(false);
                b2.create();
                b2.show();
                return true;
            }
        });
    }

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

        @JavascriptInterface
        public void tipsInfo(String arg) {
//            ToastUtil.showToast(mContext, arg);
        }
    }
}
