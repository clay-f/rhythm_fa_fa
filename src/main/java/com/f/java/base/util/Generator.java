package com.f.java.base.util;

/**
 * Generator random T value
 *
 * @param <T> value
 */
public interface Generator<T> {
    /**
     * return random generate value
     *
     * @return
     */
    T next();
}
