package com.quliantrip.qulian.util;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import java.util.ArrayList;

/**
 * Created by yuly on 2015/11/10.
 *
 */
public class CoordinateUtil {

    private static LocationManager lm;
    private static MyLocationListener listener;

    public static ArrayList<Double> getCoordinate(Context context) {
        ArrayList<Double> coordinate = new ArrayList<Double>();
        lm = (LocationManager) context.getSystemService(context.LOCATION_SERVICE);

        Criteria criteria = new Criteria();
        //确定海拔
        criteria.setAltitudeRequired(true);
        String bestProvider = lm.getBestProvider(criteria, true);
        listener = new MyLocationListener();

        //1定位的方式，2最小的时间间隔，3最小的距离，4定位的监听
//        lm.requestLocationUpdates(bestProvider, 0, 0, listener);
        return coordinate;
    }

    private static class MyLocationListener implements LocationListener {
        //当定位位置改变的调用的方法
        //Location : 当前的位置
        @Override
        public void onLocationChanged(Location location) {
            location.getAccuracy();//获取精确位置
            location.getAltitude();//获取海拔
            double latitude = location.getLatitude();//获取纬度，平行
            double longitude = location.getLongitude();//获取经度，垂直

        }

        //当定位状态发生改变的时候调用的方式
        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        //当定位可用的时候调用的方法
        @Override
        public void onProviderEnabled(String provider) {

        }

        //当定位不可用的时候调用的方法
        @Override
        public void onProviderDisabled(String provider) {

        }

    }

}
