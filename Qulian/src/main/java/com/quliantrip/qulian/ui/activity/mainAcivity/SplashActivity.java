package com.quliantrip.qulian.ui.activity.mainAcivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;

import com.quliantrip.qulian.R;
import com.quliantrip.qulian.util.CommonHelp;

import butterknife.ButterKnife;

public class SplashActivity extends Activity {
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        mContext = this;
        new Thread(){
            public void run() {
                SystemClock.sleep(2000);
                if(CommonHelp.getSp(mContext,"guideFirst",false)){
                    enterMain();
                    finish();
                }else{
                    enterGuide();
                    finish();
                }
            };
        }.start();
    }

    private void enterMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void enterGuide(){
        Intent intent = new Intent(this, GuideActivity.class);
        startActivity(intent);
    }

}
