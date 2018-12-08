package com.f.rhythm.helper;

import java.util.Collection;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 工具类
 */
public class SortHelper {

    public static void show(Collection<?> a) {
        Objects.requireNonNull(a);
        a.stream().forEach(x -> System.out.print(x + " "));
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


    public static <T extends Object> T[] shuffle(T[] ar) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--) {
            Integer index = rnd.nextInt(i + 1);
            T a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
        return ar;
    }

    public static void main(String[] args) {
        Integer[] a = {1, 3, 4, 5, 6, 7};

        System.out.println(max(a));
    }
}
