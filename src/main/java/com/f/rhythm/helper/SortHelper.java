package com.f.rhythm.helper;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

/**
 * 工具类
 */
public class SortHelper {
    public static void show(Object[] a) {
        Objects.requireNonNull(a);
        Arrays.stream(a).forEach(x -> {
            System.out.printf(x.toString() + " ");
        });
        System.out.println();
    }

    public static void show(Collection<?> a) {
        Objects.requireNonNull(a);
        a.stream().forEach(x -> {
            System.out.print(x + " ");
        });
        System.out.println();
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


    public static void reverse(Object[] a) {
        int n = a.length - 1;
        for (int i = 0; i <= n / 2; i++) {
            Object tmp = a[i];
            a[i] = a[n - i];
            a[n - i] = tmp;
        }
    }

    public static int max(Integer[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (max < a[i])
                max = a[i];
        }
        return max;
    }

    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }


    public static void main(String[] args) {
        Integer[] a = {1, 3, 4, 5, 6, 7};

        System.out.println(max(a));
    }
}
