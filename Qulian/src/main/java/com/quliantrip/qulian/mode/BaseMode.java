package com.quliantrip.qulian.mode;

import android.view.View;

public abstract class BaseMode<T> {
	public abstract View getModelView();

	public abstract void setData(T t);
}
