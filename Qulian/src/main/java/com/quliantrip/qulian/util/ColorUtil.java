package com.quliantrip.qulian.util;

import java.util.Random;

import android.graphics.Color;

public class ColorUtil {
	public static int randomColor(){
		Random random = new Random();
		int red = random.nextInt(150) + 50;
		int green = random.nextInt(150) + 50;// 50-199
		int blue = random.nextInt(150) + 50;// 50-199
		return Color.rgb(red, green, blue);// 根据rgb混合生成一种新的颜色
	}
}
