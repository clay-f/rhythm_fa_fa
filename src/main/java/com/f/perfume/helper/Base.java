package com.f.perfume.helper;

import java.util.Arrays;

/**
 * 工具类
 */
public class Base {
    public static void show(Object[] a) {
        Arrays.stream(a).forEach(x -> {
            System.out.printf(x.toString() + " ");
        });
        System.out.println();
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
}
