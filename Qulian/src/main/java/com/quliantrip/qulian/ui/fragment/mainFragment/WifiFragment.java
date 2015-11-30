package com.quliantrip.qulian.ui.fragment.mainFragment;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.quliantrip.qulian.R;
import com.quliantrip.qulian.base.BaseFragment;
import com.quliantrip.qulian.scanner.activity.CaptureActivity;
import com.quliantrip.qulian.scanner.activity.OpenWifiActivity;

/**
 * Created by yuly on 2015/11/9.
 */


public class WifiFragment extends BaseFragment implements View.OnClickListener{
    private Button bt;
    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_main_wifi, null);
        bt = (Button)view.findViewById(R.id.wifiManage);
        bt.setOnClickListener(this);
        return view;
    }

    @Override
    public void initDate() {
        System.out.println("wifi数据加载了。。。");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.wifiManage:
                Intent openCameraIntent = new Intent(mContext,CaptureActivity.class);
                startActivityForResult(openCameraIntent,0);
                break;
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode != Activity.RESULT_OK){
            return;
        }
        if (requestCode == 0) {
            data.setClass(mContext, OpenWifiActivity.class);
            startActivity(data);
        }
    }
}
