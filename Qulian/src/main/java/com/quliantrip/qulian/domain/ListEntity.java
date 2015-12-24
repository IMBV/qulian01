package com.quliantrip.qulian.domain;

import java.io.Serializable;
import java.util.List;

public interface ListEntity<T extends BaseJson> extends Serializable {
    public List<T> getList();
}
