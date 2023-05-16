package com.huamiao.common.function;

import java.util.List;

@FunctionalInterface
public interface Selector<T> {
    List<T> select();
}
