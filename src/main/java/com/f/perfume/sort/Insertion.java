package com.f.perfume.sort;

import static com.f.perfume.helper.Base.*;

/**
 * 插入排序
 */
public class Insertion {
    public static void sort(Integer[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] a = {8, 2, 1, 15, 90, 18, 4, 3, 99};
        sort(a);
        show(a);
    }
}
