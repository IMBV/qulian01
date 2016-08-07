package com.quliantrip.qulian.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.quliantrip.qulian.domain.BaseJson;
import com.quliantrip.qulian.net.volleyManage.QuestBean;
import com.quliantrip.qulian.util.CommonHelp;

import de.greenrobot.event.EventBus;

/**
 * Created by Yuly on 2015/12/2.
 * www.quliantrip.com
 */
public abstract class BasePageCheckFragment extends Fragment {
    protected Context mContext;
    protected ContentPage contentPage;

    public BaseJson objectJson;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = (Context) getActivity();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (contentPage == null) {
            EventBus.getDefault().register(this);
            contentPage = new ContentPage(getActivity()) {

                @Override
                protected View createSuccessView() {
                    return getSuccessView();
                }

                @Override
                protected QuestBean setQuestBean() {
                    return requestData();
                }
            };
        } else {
            // fragmen在添加到容器是会建立到noSaveStateFrameLayou中在进行添加到容器中.
            // 如果没有移除会报一个该View有一个父类了。
            CommonHelp.removeSelfFromParent(contentPage);
        }
        return contentPage;
    }


    protected abstract View getSuccessView();

    protected abstract QuestBean requestData();

    public abstract void onEventMainThread(BaseJson bean);
}
