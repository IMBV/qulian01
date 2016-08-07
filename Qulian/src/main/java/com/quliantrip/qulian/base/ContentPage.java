package com.quliantrip.qulian.base;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.google.gson.Gson;
import com.quliantrip.qulian.R;
import com.quliantrip.qulian.domain.BaseJson;
import com.quliantrip.qulian.global.QulianApplication;
import com.quliantrip.qulian.net.volleyManage.PacketStringReQuest;
import com.quliantrip.qulian.net.volleyManage.QuestBean;
import com.quliantrip.qulian.net.volleyManage.ResponseListenner;
import com.quliantrip.qulian.util.CommonHelp;
import com.quliantrip.qulian.util.ToastUtil;

import de.greenrobot.event.EventBus;

public abstract class ContentPage extends FrameLayout {
    private QuestBean questBean;//请求数据的对象
    //请求后的状态
    public static final int STATE_LOADING = 0;
    public static final int STATE_SUCCESS = 1;
    public static final int STATE_ERROR = 2;
    //当前界面的状态
    private int mState = STATE_LOADING;

    //对应请求返回的界面
    private View loadingView;
    private View errorView;
    private View successView;

    public ContentPage(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initContentView();
    }

    public ContentPage(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ContentPage(Context context) {
        this(context, null);
    }

    public void initContentView() {
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT);
        if (loadingView == null) {
            loadingView = View.inflate(getContext(), R.layout.view_page_loading, null);
        }
        addView(loadingView, params);
        if (errorView == null) {
            errorView = View.inflate(getContext(), R.layout.view_page_error, null);
            Button button = (Button) errorView.findViewById(R.id.btn_reload);
            button.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    mState = STATE_LOADING;
                    showPage();
                    loadDataAndRefreshPage();
                }
            });
        }
        addView(errorView, params);
        if (successView == null) {
            successView = createSuccessView();
        }
        if (successView != null) {
            addView(successView, params);
        }
        showPage();
        loadDataAndRefreshPage();
    }

    // 进行数据的请求和界面的改变
    public void loadDataAndRefreshPage() {
        questBean = setQuestBean();
        if (questBean == null) {
            mState = STATE_ERROR;
            CommonHelp.runOnUIThread(new Runnable() {

                @Override
                public void run() {
                    ToastUtil.showToast(QulianApplication.getContext(), "没有返回请求对象");
                    showPage();
                }
            });
            return;
        }
        BaseJson object = questBean.getObject();
        String tag = null;
        if (object != null) {
            tag = object.getTag();
        }
        String baseJson = CommonHelp.getStringSp(QulianApplication.getContext(), tag, "");
        if (!TextUtils.isEmpty(baseJson)) {
            object = new Gson().fromJson(baseJson, object.getClass());
            object.setTag(tag);
            mState = STATE_SUCCESS;
            CommonHelp.runOnUIThread(new Runnable() {

                @Override
                public void run() {
                    if (mState == STATE_SUCCESS) {
                        showPage();
                    }
                }
            });
            EventBus.getDefault().post(object);
        }
        if (questBean.getMap() != null) {
            new PacketStringReQuest(questBean.getUrl(), questBean.getObject(), questBean.getMap(), new ResponseListenner.OnLoadFinishListener() {
                @Override
                public void onLoadFinish(int state) {
                    mState = state;
                    CommonHelp.runOnUIThread(new Runnable() {

                        @Override
                        public void run() {
                            showPage();
                        }
                    });
                }
            });
        } else {
            new PacketStringReQuest(questBean.getUrl(), questBean.getObject(), new ResponseListenner.OnLoadFinishListener() {
                @Override
                public void onLoadFinish(int state) {
                    mState = state;
                    CommonHelp.runOnUIThread(new Runnable() {

                        @Override
                        public void run() {
                            showPage();
                        }
                    });
                }
            });
        }

    }

    // 根据状态进行显示不同的界面
    private void showPage() {
        loadingView.setVisibility(View.INVISIBLE);
        successView.setVisibility(View.INVISIBLE);
        errorView.setVisibility(View.INVISIBLE);
        switch (mState) {
            case STATE_LOADING:
                loadingView.setVisibility(View.VISIBLE);
                break;
            case STATE_SUCCESS:
                successView.setVisibility(View.VISIBLE);
                break;
            case STATE_ERROR:
                errorView.setVisibility(View.VISIBLE);
                break;
        }
    }

    protected abstract View createSuccessView();

    protected abstract QuestBean setQuestBean();
}
