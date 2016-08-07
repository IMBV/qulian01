package com.quliantrip.qulian.ui.activity.mainAcivity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.quliantrip.qulian.R;
import com.quliantrip.qulian.ui.fragment.mainFragment.ChoicenessFragment;
import com.quliantrip.qulian.ui.fragment.mainFragment.HomeFragment;
import com.quliantrip.qulian.ui.fragment.mainFragment.MyFragment;
import com.quliantrip.qulian.util.ToastUtil;
import com.readystatesoftware.systembartint.SystemBarTintManager;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import me.imid.swipebacklayout.lib.SwipeBackLayout;

public class MainActivity extends FragmentActivity {
    private static final int VIBRATE_DURATION = 20;
    private SwipeBackLayout mSwipeBackLayout;

    private ArrayList<Fragment> listFragment = new ArrayList<Fragment>();
    private RadioGroup radioGroup;
    private FrameLayout fullContent;
    private SystemBarTintManager mTintManager;
    private Fragment mTempFragment;
    private ChoicenessFragment choicenessFragment;

//    //处理显示的结果
//    private Handler handler = new Handler(){
//        public void handleMessage(android.os.Message msg) {
//
//        };
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        applyKitKatTranslucency();
        setStatusBarTextColor(this, 1);
        initData();
//        vertionCode = getVersionName();
    }


//    private String vertionCode;
//    //版本更细对话框提示
//    private void alterDowm(){
//        AlertDialog.Builder builder = new Builder(this);
//        //设置点击其他地方无效
//        builder.setCancelable(false);
//        builder.setIcon(R.mipmap.ic_icon);
//        builder.setTitle("新版本："+vertionCode);
////        builder.setMessage(des);
//        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.dismiss();
//            }
//        });
//        builder.setPositiveButton("升级", new DialogInterface.OnClickListener() {
//
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dowmloadApk();
//
//            }
//        });
//        builder.show();
//    }
//    //下载更新更新的apk文件
//    private void dowmloadApk(){
////        HttpUtils utils = new HttpUtils();
//        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
////            utils.download(apkUrl, Environment.getExternalStorageDirectory().getPath()+"/phonesafe.apk"
////                    , new RequestCallBack<File>() {
////                        @Override
////                        public void onSuccess(ResponseInfo<File> arg0) {
////                            Toast.makeText(getApplicationContext(), "下载成功", 0).show();
////                            downloadInstall();
////                        }
////
////                        @Override
////                        public void onFailure(HttpException arg0, String arg1) {
////                            Toast.makeText(getApplicationContext(), "下载失败", 0).show();
////                            enterMenu();
////                        }
////                        @Override
////                        public void onLoading(long total, long current,
////                                              boolean isUploading) {
////                            super.onLoading(total, current, isUploading);
////                            // 设置控件可见
////                            tv_msg_down.setVisibility(View.VISIBLE);
////                            tv_msg_down.setText(current + "/" + total);// 123/500
////                        }
////                    });
//        }else{
//            ToastUtil.showToast(getApplicationContext(), "sd卡没有打卡");
////            enterMenu();
//        }
//    }
//
//    //下载后进入安装文件
//    private void downloadInstall(){
//        //开启一个隐式意图打开系统应用的安装文件
//        Intent intent = new Intent();
//        intent.setAction("android.intent.action.VIEW");
//        intent.addCategory("android.intent.category.DEFAULT");
//        intent.setDataAndType(Uri.fromFile(new File(Environment.getExternalStorageDirectory().getPath()+"/phonesafe.apk")),
//                "application/vnd.android.package-archive");
//        startActivityForResult(intent, 0);
//    }
//    //接收安装取消后的返回的操作
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
////        enterMenu();
//    }
//
//    //读取服务器上的更新信息的情况
//    private void conn() {
////        new Thread(){
////            public void run() {
////                Message msg = Message.obtain();
////                long startTime = System.currentTimeMillis();
////                try {
////                    //获取链接
////                    URL url = new URL("http://version.html");
////                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
////                    //设置请求的属性
////                    conn.setRequestMethod("GET");
////                    conn.setConnectTimeout(1000*3);//请求超时
//////					conn.setReadTimeout(1000*5);//读取超时
////                    //根据请求响应码返回的数值进行判断对应的操作
////                    int code = conn.getResponseCode();
////                    if(code == 200){
////                        InputStream in = conn.getInputStream();
////                        //使用工工具吧流对象转化为字符串
////                        String json = ParseStream.getStingFromInstream(in);
////                        //构建json对象获取内部的资料
////                        JSONObject jo = new JSONObject(json);
////                        vertionCode = jo.getString("code");
////                        apkUrl = jo.getString("apkUrl");
////                        des = jo.getString("des");
////                        //判服务器的本地的版本号是否一致进行不同的操作
////                        if(vertionCode.equals(getVersionName())){
////                            msg.what = MSG_VERSION_NO;
////                        }else{
////                            msg.what = MSG_VERSION_YES;
////                        }
////                    }else{
////                        msg.what = MSG_INTENNET_NO;
////                    }
////                } catch (MalformedURLException e) {
////                    msg.what = MSG_ERROR_URL;
////                } catch (IOException e) {
////                    msg.what = MSG_ERROR_IO;
////                } catch (JSONException e) {
////                    msg.what = MSG_ERROR_JSON;
////                }finally{
////                    long endTime = System.currentTimeMillis();
////                    long dTime = endTime - startTime;
////                    if(dTime < 1000*2){
////                        SystemClock.sleep(2000-dTime);
////                    }
////                    handler.sendMessage(msg);
////                }
////            };
////        }.start();
//    }
//
////    //进入主页面的方法
////    private void enterMenu(){
////        Intent intent = new Intent(this,MenuActivity.class);
////        startActivity(intent);
////        finish();
////    }
//
//
//    //获取清单文件的名称
//    private String getVersionName(){
//        PackageManager pm = getPackageManager();
//        try {
//            //当数据为零是会获取文件包的基本信息如版本和基础信息
//            PackageInfo packageInfo = pm.getPackageInfo(getPackageName(), 0);
//            return packageInfo.versionName;
//        } catch (PackageManager.NameNotFoundException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    //添加数据和对RadioGrope的显示进行监听
    private void initData() {
        radioGroup = (RadioGroup) findViewById(R.id.main_radio);
        fullContent = (FrameLayout) findViewById(R.id.fl_content);
        //添加要进行替换的Fragment
        listFragment.clear();
        HomeFragment homeFragment = new HomeFragment();
        mTempFragment = homeFragment;


        getSupportFragmentManager().beginTransaction().add(R.id.fl_content, homeFragment)
                .commit();

//        HappinessFragment happinessFragment = new HappinessFragment();
//        FindFragment findFragment = new FindFragment();
        if(choicenessFragment == null){
            choicenessFragment = new ChoicenessFragment();
        }
        MyFragment myFragment = new MyFragment();

        listFragment.add(homeFragment);
//        listFragment.add(happinessFragment);
//        listFragment.add(findFragment);
        listFragment.add(choicenessFragment);
        listFragment.add(myFragment);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int index = 0;
                switch (checkedId) {
                    case R.id.rb_home_page:
                        index = 0;
                        if(listFragment.get(index).isAdded()){
                            choicenessFragment.setAllNot();
                        }
                        choicenessFragment.hidePopupWindow();
                        break;
                    case R.id.rb_choiceness_page:
                        index = 1;
                        break;
                    case R.id.rb_myinfo_page:
                        index = 2;
                        if(listFragment.get(index).isAdded()){
                            choicenessFragment.setAllNot();
                        }
                        choicenessFragment.hidePopupWindow();
                        break;
                }
                switchFragment(listFragment.get(index));
//                getSupportFragmentManager().beginTransaction().replace(R.id.fl_content, listFragment.get(index)).commit();
            }
        });
        radioGroup.check(R.id.rb_home_page);
    }

    //进入要切换fragment,
    private void switchFragment(Fragment fragment) {
        if (fragment != mTempFragment) {
            if (!fragment.isAdded()) {
                getSupportFragmentManager().beginTransaction().hide(mTempFragment)
                        .add(R.id.fl_content, fragment).commit();
            } else {
                getSupportFragmentManager().beginTransaction().hide(mTempFragment)
                        .show(fragment).commit();
            }
            mTempFragment = fragment;
        }
    }

    private void applyKitKatTranslucency() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
            mTintManager = new SystemBarTintManager(this);
            mTintManager.setStatusBarTintEnabled(true);
            mTintManager.setNavigationBarTintEnabled(true);
            mTintManager.setTintColor(android.R.color.white);
        }
    }

    @TargetApi(19)
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    /**
     * 只支持MIUI V6
     *
     * @param context
     * @param type    0--只需要状态栏透明 1-状态栏透明且黑色字体 2-清除黑色字体
     */
    public static void setStatusBarTextColor(Activity context, int type) {
        Window window = context.getWindow();
        Class clazz = window.getClass();
        try {
            int tranceFlag = 0;
            int darkModeFlag = 0;
            Class layoutParams = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            Field field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_TRANSPARENT");
            tranceFlag = field.getInt(layoutParams);
            field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");
            darkModeFlag = field.getInt(layoutParams);
            Method extraFlagField = clazz.getMethod("setExtraFlags", int.class, int.class);
            if (type == 0) {
                extraFlagField.invoke(window, tranceFlag, tranceFlag);//只需要状态栏透明
            } else if (type == 1) {
                extraFlagField.invoke(window, tranceFlag | darkModeFlag, tranceFlag | darkModeFlag);//状态栏透明且黑色字体
            } else {
                extraFlagField.invoke(window, 0, darkModeFlag);//清除黑色字体
            }
        } catch (Exception e) {

        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitBy2Click(); //调用双击退出函数
        }
        return false;
    }

    /**
     * 双击退出函数
     */
    private static Boolean isExit = false;

    private void exitBy2Click() {
        Timer tExit = null;
        if (isExit == false) {
            isExit = true; // 准备退出
            ToastUtil.showToast(this, "再按一次退出程序");
            tExit = new Timer();
            tExit.schedule(new TimerTask() {
                @Override
                public void run() {
                    isExit = false; // 取消退出
                }
            }, 2000); // 如果2秒钟内没有按下返回键，则启动定时器取消掉刚才执行的任务

        } else {
            finish();
            System.exit(0);
        }
    }

    //加载选着大分类的消费列表并显示
    public void changeChoicenessContion(String name,String id){
        if(choicenessFragment == null){
            choicenessFragment = new ChoicenessFragment();
        }
        if(!choicenessFragment.isAdded()){
            choicenessFragment.changeBigSortNoFragemnt(name,id);
            switchFragment(choicenessFragment);
        }else{
            switchFragment(choicenessFragment);
            choicenessFragment.changeBigSort(name,id);
        }
        ((RadioButton)findViewById(R.id.rb_choiceness_page)).setChecked(true);
    }
}
