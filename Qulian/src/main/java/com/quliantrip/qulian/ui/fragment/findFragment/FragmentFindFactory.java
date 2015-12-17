package com.quliantrip.qulian.ui.fragment.findFragment;

import android.support.v4.app.Fragment;

//用于建立fragment的工厂类
public class FragmentFindFactory {
    public static Fragment create(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new VoiceNavigattionFragtment();
                break;
            case 1:
                fragment = new ShowPicFragtment();
                break;


        }
        return fragment;
    }
}
