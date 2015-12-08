package com.quliantrip.qulian.service;

import android.Manifest;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.ActivityCompat;


public class GpsService extends Service {
    private SharedPreferences sp;
    private LocationManager lm;
    private MyLocationListener listener;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        lm = (LocationManager) getSystemService(LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        //确定海拔
        criteria.setAltitudeRequired(true);
        String bestProvider = lm.getBestProvider(criteria, true);
        listener = new MyLocationListener();
        //判断是否有权限的额添加
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        //1定位的方式，2最小的时间间隔，3最小的距离，4定位的监听
        lm.requestLocationUpdates(bestProvider, 0, 0, listener);
    }

    class MyLocationListener implements LocationListener {

        @Override
        //坐标的位置发生变化是调用
        public void onLocationChanged(Location location) {
            //location表示的是定位的位置
            location.getAccuracy();
            location.getAltitude();
            double latitude = location.getLatitude();
            double longitude = location.getLongitude();
            stopSelf();//这里是进行关闭开启的服务
        }

        //定位的状态发生变化
        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            // TODO Auto-generated method stub

        }

        //当定位可调用的时候进行
        @Override
        public void onProviderEnabled(String provider) {
            // TODO Auto-generated method stub

        }

        //当定位不可调用的时候调用
        @Override
        public void onProviderDisabled(String provider) {
            // TODO Auto-generated method stub

        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        lm.removeUpdates(listener);
    }

}
