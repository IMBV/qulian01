package com.quliantrip.qulian.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.TextView;

import com.quliantrip.qulian.R;
import com.quliantrip.qulian.base.BaseSwipeBackActivity;
import com.quliantrip.qulian.global.SimpleBackPage;

import java.lang.ref.WeakReference;

public class SimpleBackActivity extends BaseSwipeBackActivity {

    public final static String BUNDLE_KEY_PAGE = "BUNDLE_KEY_PAGE";
    public final static String BUNDLE_KEY_ARGS = "BUNDLE_KEY_ARGS";
    private static final String TAG = "FLAG_TAG";
    protected WeakReference<Fragment> mFragment;
    protected int mPageValue = -1;

    @Override
    protected void onActivityResult(int arg0, int arg1, Intent arg2) {
        super.onActivityResult(arg0, arg1, arg2);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_simple_fragment;
    }

    @Override
    public void initFindView() {
        if (mPageValue == -1) {
            mPageValue = getIntent().getIntExtra(BUNDLE_KEY_PAGE, 0);
        }
        initFromIntent(mPageValue, getIntent());
    }

    @Override
    public void initData() {
    }

    protected void initFromIntent(int pageValue, Intent data) {
        if (data == null) {
            throw new RuntimeException(
                    "you must provide a page info to display");
        }
        SimpleBackPage page = SimpleBackPage.getPageByValue(pageValue);
        if (page == null) {
            throw new IllegalArgumentException("can not find page by value:"
                    + pageValue);
        }

        setActionTitle(page.getTitle());

        try {
            Fragment fragment = (Fragment) page.getClz().newInstance();

            Bundle args = data.getBundleExtra(BUNDLE_KEY_ARGS);
            if (args != null) {
                fragment.setArguments(args);
            }

            FragmentTransaction trans = getSupportFragmentManager()
                    .beginTransaction();
            trans.replace(R.id.container, fragment, TAG);
            trans.commitAllowingStateLoss();

            mFragment = new WeakReference<Fragment>(fragment);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException(
                    "generate fragment error. by value:" + pageValue);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void setActionTitle(int actionTitle) {
        ((TextView)findViewById(R.id.tv_Title_name)).setText(getString(actionTitle));
    }

    //    @Override
//    protected boolean hasBackButton() {
//        return true;
//    }

//    @Override
//    public void onBackPressed() {
//        if (mFragment != null && mFragment.get() != null
//                && mFragment.get() instanceof BaseFragment) {
//            BaseFragment bf = (BaseFragment) mFragment.get();
//            if (!bf.onBackPressed()) {
//                super.onBackPressed();
//            }
//        } else {
//            super.onBackPressed();
//        }
//    }
//
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.ACTION_DOWN
//                && mFragment.get() instanceof BaseFragment) {
//            ((BaseFragment) mFragment.get()).onBackPressed();
//        }
//        return super.onKeyDown(keyCode, event);
//    }

}
