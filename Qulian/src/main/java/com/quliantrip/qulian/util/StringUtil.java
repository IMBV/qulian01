package com.quliantrip.qulian.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtil {
	/**
	 * 将long类型的时间转为 01:22:33这样格式的
	 * 
	 * @param duration
	 * @return
	 */
	public static String formatVideoDuration(long duration){
		int HOUR = 60 * 60 *1000;//1小时对应的毫秒数
		int MINUTE = 60 * 1000;//
		int SECOND = 1000;//
		
		long remainTime;
		//1.先算出多少小时，然后拿剩余的时间去算分钟
		int hour = (int) (duration/HOUR);//得到多少小时
		remainTime = duration % HOUR;//得到算完小时剩余的时间
		//2.算出多少分钟，然后再拿剩余的时间去算秒
		int minute = (int) (remainTime / MINUTE);//得到多少分钟
		remainTime = remainTime % MINUTE;//得到算完分钟后剩余的时间
		//3.算出多少秒
		int second = (int) (remainTime/SECOND);//得到多少秒
		
		
		if(hour==0){
			//显示为22:33
			return String.format("%02d:%02d", minute,second);
		}else {
			return String.format("%02d:%02d:%02d",hour, minute,second);
		}
	}
	
	/**
	 * 格式当前的时间为01:22:33
	 * @return
	 */
	public static String formatCurrentTime(){
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		return format.format(new Date());
	}
	
	/**
	 * 去掉歌曲名称的后缀.mp3
	 * @param name
	 * @return
	 */
	public static String formatAudioName(String name){
		int lastDotIndex = name.lastIndexOf(".");
		return name.substring(0, lastDotIndex);
	}
}
