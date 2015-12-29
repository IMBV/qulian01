package com.quliantrip.qulian.scanner.activity;



import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.quliantrip.qulian.scanner.wifi.WifiAdmin;

public class OpenWifiActivity extends Activity {

	private WifiAdmin wifiAdmin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		wifiAdmin = new WifiAdmin(this);

		LinearLayout linearLayout = new LinearLayout(this);
		linearLayout.setGravity(Gravity.CENTER);
		LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT);
		linearLayout.setLayoutParams(layoutParams);
		TextView textView = new TextView(this);
		textView.setText("正在连接wifi...");
		textView.setTextColor(Color.RED);
		linearLayout.addView(textView);
		setContentView(linearLayout);
		final Intent data = getIntent();
		new Thread(new Runnable() {

			@Override
			public void run() {
				Bundle bundle = data.getExtras();
				String scanResult = bundle.getString("result");
				String[] string = scanResult.split(";");
				String name = string[0];
				String password = string[1];
				String editText1 = name.split(":")[1];
				String editText2 = password.split(":")[1];
				wifiAdmin.openWifi();
				// 这里在主线程中睡是不对的。
				try {
					Thread.sleep(4000);// 休眠3s，不休眠则会在程序首次开启WIFI时候，处理getScanResults结果，wifiResultList.size()发生异常
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				wifiAdmin.setAddNetWorkFinishListener(new WifiAdmin.AddNetWorkFinishListener() {

							@Override
							public void onFinishActivity() {
								OpenWifiActivity.this.finish();
								runOnUiThread(new Runnable() {

									@Override
									public void run() {
										Toast.makeText(OpenWifiActivity.this,
												"wifi连接成功", Toast.LENGTH_SHORT).show();
									}
								});

							}
						});
				wifiAdmin.addNetwork(wifiAdmin.CreateWifiInfo(editText1.trim(),
						editText2.trim(), 3));
			}
		}).start();
	}
}
