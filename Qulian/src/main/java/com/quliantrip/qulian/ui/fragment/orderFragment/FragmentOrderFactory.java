package com.quliantrip.qulian.ui.fragment.orderFragment;

import android.support.v4.app.Fragment;

import com.quliantrip.qulian.ui.fragment.findFragment.ShowPicFragtment;
import com.quliantrip.qulian.ui.fragment.findFragment.VoiceNavigattionFragtment;

//用于建立fragment的工厂类
public class FragmentOrderFactory {
    public static Fragment create(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new ShowFram();
                break;
            case 1:
                fragment = new ShowFram();
                break;
            case 2:
                fragment = new ShowFram();
                break;
            case 3:
                fragment = new ShowFram();
                break;
        }
        return fragment;
    }
}
