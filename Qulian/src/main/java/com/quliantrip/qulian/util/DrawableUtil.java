package com.quliantrip.qulian.util;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;

/**
 * 这里是进行代码的方式进行加载shape对象
 */
public class DrawableUtil {
    /**
     * @param argb
     * @param radius
     * @return 代码实现shape的值进行设置
     */
    public static GradientDrawable generateDrawable(int argb, float radius) {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(GradientDrawable.RECTANGLE);// 设置为矩形，默认就是矩形
        drawable.setCornerRadius(radius);// 设置圆角的半径
        drawable.setColor(argb);
        return drawable;
    }

    /**
     * @param pressed
     * @param normal
     * @return selector的drawable的画面的布局
     */
    public static StateListDrawable generateSelector(Drawable pressed,
                                                     Drawable normal) {
        StateListDrawable drawable = new StateListDrawable();
        drawable.addState(new int[]{android.R.attr.state_pressed}, pressed);// 设置按下的图片
        drawable.addState(new int[]{}, normal);// 设置默认的图片
        return drawable;
    }

}
