package com.quliantrip.qulian.domain;

import java.io.Serializable;
/**
 * 所有类的基类
 * */
public class BaseJson implements Serializable {
	private String tag;//设置请求数据的标示

	public String getTag() {
		return tag;
	}

	public BaseJson setTag(String tag) {
		this.tag = tag;
		return this;
	}
}
